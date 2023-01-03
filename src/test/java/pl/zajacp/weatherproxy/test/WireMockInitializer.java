package pl.zajacp.weatherproxy.test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.PropertySource;
import org.springframework.mock.env.MockPropertySource;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WireMockInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final String WIREMOCK_BEAN_NAME = "wireMockServer";
    private static final String WIREMOCK_PROPERTIES_NAME = "wiremockDynamicProperties";
    private static final String WIREMOCK_PROPERTIES_PORT = "wiremock.http.port";

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext applicationContext) {
        WireMockServer wireMockServer = startWireMockServer(getWireMockConfig());
        applicationContext.getBeanFactory().registerSingleton(WIREMOCK_BEAN_NAME, wireMockServer);
        applicationContext.getEnvironment().getPropertySources().addFirst(getWireMockPropertySource(wireMockServer));
    }

    private WireMockServer startWireMockServer(WireMockConfiguration config) {
        WireMockServer server = new WireMockServer(config);
        server.start();
        log.info("Wiremock started at port: " + server.port());
        return server;
    }

    private WireMockConfiguration getWireMockConfig() {
        return new WireMockConfiguration()
                .dynamicPort()
                .notifier(new Slf4jNotifier(true));
    }

    private PropertySource<?> getWireMockPropertySource(WireMockServer wireMockServer) {
        return new MockPropertySource(WIREMOCK_PROPERTIES_NAME)
                .withProperty(WIREMOCK_PROPERTIES_PORT, wireMockServer.port());
    }
}
