package com.example.mycovidsample.Network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoronaApi {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://corona.lmao.ninja/v2/";

//    public static final String PREFERENCES_EMAIL_KEY = "email";
public static final String FIREBASE_QUERY_INDEX = "index";
    public static final String FIREBASE_CHILD_Email = "email";

    public static final String FIREBASE_CHILD_Password = "password";


    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

