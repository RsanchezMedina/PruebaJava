package com.rsanchez.appareaseysjava.repository;

import com.rsanchez.appareaseysjava.interfaces.ApiConection;
import com.rsanchez.appareaseysjava.interfaces.BaseCallback;
import com.rsanchez.appareaseysjava.modelo.Personas;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RepositoryData {

    public void getDataRepository(Retrofit retrofit, final BaseCallback.OnSuccess<List<Personas>> onSuccess, final BaseCallback.OnError<Error> error) {
        Call<List<Personas>> call = retrofit.create(ApiConection.class).getDataPersonas();
        call.enqueue(new Callback<List<Personas>>() {
            @Override
            public void onResponse(Call<List<Personas>> call, Response<List<Personas>> response) {
                if (response.body() != null) {
                    onSuccess.OnResponse(response.body());
                } else {
                    error.OnError(new Error("Datos no Disponibles"));
                }
            }

            @Override
            public void onFailure(Call<List<Personas>> call, Throwable t) {
                error.OnError(new Error("Datos no Disponibles"));
            }
        });

    }

}
