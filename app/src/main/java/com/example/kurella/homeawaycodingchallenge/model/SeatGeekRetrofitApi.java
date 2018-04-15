package com.example.kurella.homeawaycodingchallenge.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SeatGeekRetrofitApi {

    //https://api.seatgeek.com/2/events?client_id=<your client id>&q=Texas+Ranger

    String BASE_URL = "https://api.seatgeek.com/";

    String client_id = "MTEyMzEzODh8MTUyMzgxMTk3Mi42MQ";

    @GET("2/events")
    Call<DataPojo> getLocations(@Query("client_id") String client_id, @Query("q") String q);

}
