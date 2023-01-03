package pl.zajacp.weatherproxy.adapter.accu;

import pl.zajacp.weatherproxy.adapter.accu.model.forecast.WeatherResponse;
import pl.zajacp.weatherproxy.adapter.accu.model.location.LocationResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAccuWeatherClient {

    @GET("/locations/v1/postalcodes/PL/search")
    Call<LocationResponse> getLocationByKey(String locationKey, String apikey);

    @GET("/forecasts/v1/daily/5day/{locationKey}")
    Call<WeatherResponse[]> get5DayWeather(String locationKey, String apikey);
}
