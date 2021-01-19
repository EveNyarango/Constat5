package com.example.mycovidsample.Network;

import com.example.mycovidsample.models.AllCountriesResponse;
import com.example.mycovidsample.models.CountriesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoronaService {

    @GET("countries/?sort=country")
    Call<List<CountriesResponse>> getCountries();


    @GET("countries/{country}")
    Call<CountriesResponse> getCountryInfo(

            @Path("country") String country
    );

    @GET("all")
    Call<AllCountriesResponse> getAllCountries();
}


