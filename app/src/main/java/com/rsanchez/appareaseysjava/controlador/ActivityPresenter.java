package com.rsanchez.appareaseysjava.controlador;

import androidx.lifecycle.MutableLiveData;

import com.rsanchez.appareaseysjava.modelo.Personas;
import com.rsanchez.appareaseysjava.repository.RepositoryConfig;
import com.rsanchez.appareaseysjava.repository.RepositoryData;

import java.util.List;

public class ActivityPresenter {

    private MutableLiveData<List<Personas>> listaPersonas;
    private MutableLiveData<Error> errorConection;

    private RepositoryData repository;
    private RepositoryConfig repositoryConfig;

    public ActivityPresenter() {
        repository = new RepositoryData();
        repositoryConfig = RepositoryConfig.getInstance();
    }


    public MutableLiveData<List<Personas>> getListaPersonas() {
        if (listaPersonas == null) {
            listaPersonas = new MutableLiveData<>();
        }
        return listaPersonas;
    }

    public MutableLiveData<Error> getErrorConection() {
        if (errorConection == null) {
            errorConection = new MutableLiveData<>();
        }
        return errorConection;
    }

    public void getDataPersonas() {
        if (repository != null) {
            repository.getDataRepository(repositoryConfig.getRetrofit(),
                    list -> {
                        getListaPersonas().setValue(list);
                    },
                    error -> {
                        getErrorConection().setValue(error);
                    });
        }
    }


}
