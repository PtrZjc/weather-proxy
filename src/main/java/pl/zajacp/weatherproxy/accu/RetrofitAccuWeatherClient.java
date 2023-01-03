package pl.zajacp.weatherproxy.accu;

import pl.zajacp.weatherproxy.accu.model.AccuLocationResponse;
import pl.zajacp.weatherproxy.accu.model.AccuWeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAccuWeatherClient {

    @GET("/locations/v1/postalcodes/PL/search")
    Call<AccuLocationResponse[]> getLocationByKey(@Query("q") String postalCode, @Query("apikey") String apiKey);

    @GET("/forecasts/v1/daily/5day/{locationKey}")
    Call<AccuWeatherResponse> get5DayForecast(@Path("locationKey") String locationKey, @Query("apikey") String apikey);
}
