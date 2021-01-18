package com.example.mycovidsample.network;

import com.example.mycovidsample.models.CovidCases;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidApi {
    @GET("cases")
    Call<CovidCases> getCases(
            @Query("country") String country
    );

}
