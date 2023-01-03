package pl.zajacp.weatherproxy.adapter.accu;

import pl.zajacp.weatherproxy.adapter.accu.model.forecast.WeatherResponse;
import pl.zajacp.weatherproxy.adapter.accu.model.location.LocationResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAccuWeatherClient {

    @GET("/locations/v1/postalcodes/PL/search")
    Call<LocationResponse> getLocationByKey(@Query("q") String postalCode, @Query("apikey") String apiKey);

    @GET("/forecasts/v1/daily/5day/{locationKey}")
    Call<WeatherResponse[]> get5DayForecast(@Path("locationKey") String locationKey,  @Query("apikey") String apikey);
}
