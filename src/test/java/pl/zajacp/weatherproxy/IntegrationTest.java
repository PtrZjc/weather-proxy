package pl.zajacp.weatherproxy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.zajacp.weatherproxy.commons.ApiHelper;
import pl.zajacp.weatherproxy.commons.TestData;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("integration")
@AutoConfigureMockMvc
class IntegrationTest {

    @Autowired
    private ApiHelper apiHelper;

    @Test
    void contextLoads() {
        //not yet mocked
        apiHelper.getErrorResponseExpectingStatus(TestData.ZIP_CODE, status().isInternalServerError());
    }
}
