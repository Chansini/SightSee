package com.example.sightsee;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MyInterface {
    String BASE_URL = "http://10.0.2.2/sightSee/";
    @GET("list_place.php")
    Call<List<Place>> getPlace();

    @GET("list_place.php")
    Call<Place> getPlaceDetile();


}
