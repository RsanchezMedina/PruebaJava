package com.rsanchez.appareaseysjava.interfaces;

import com.rsanchez.appareaseysjava.modelo.Personas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConection {

    @GET("5e972b443000008c00b6dc60")
    Call<List<Personas>> getDataPersonas();

}
