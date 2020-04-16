package com.rsanchez.appareaseysjava.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositoryConfig {
    private Retrofit retrofit;
    private static RepositoryConfig repositoryConfig;
    private String BASE_URL = "http://www.mocky.io/v2/";

    public RepositoryConfig() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static RepositoryConfig getInstance() {
        if (repositoryConfig == null) {
            repositoryConfig = new RepositoryConfig();
        }
        return repositoryConfig;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


}
