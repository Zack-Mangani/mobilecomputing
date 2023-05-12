package com.example.monitorit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
//code represents an API definition for making an HTTP GET request to retrieve fixture responses
    @GET("/api/v1/json/3/eventslast.php?id=133602")
    Call<ApiResponse> getFixtureResponses();


}



