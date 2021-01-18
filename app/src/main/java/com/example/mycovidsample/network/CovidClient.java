package com.example.mycovidsample.network;

import com.example.mycovidsample.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CovidClient {
        private static Retrofit retrofit = null;
        private static final String BASE_URL = Constants.COVID_BASE_URL;

        public static CovidApi getClient() {
            if (retrofit == null){

                retrofit = new Retrofit.Builder().baseUrl(Constants.COVID_BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit.create(CovidApi.class);
        }
    }


