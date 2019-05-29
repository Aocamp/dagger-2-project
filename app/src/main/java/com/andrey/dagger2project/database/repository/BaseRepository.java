package com.andrey.dagger2project.database.repository;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.andrey.dagger2project.database.AppDatabase;
import com.andrey.dagger2project.database.dao.BaseDao;
import com.andrey.dagger2project.database.model.BaseModel;

import java.util.List;

public abstract class BaseRepository<T extends BaseModel, D extends BaseDao<T>> {
    private D dao;

    public BaseRepository(D dao){
        this.dao = dao;
    }

    public D getDao() {
        return dao;
    }

    @SuppressLint("StaticFieldLeak")
    public void insert (T t){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dao.insert(t);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void insertAll (List<T> t){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dao.insertAll(t);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void deleteAll(T t) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dao.delete(t);
                return null;
            }
        }.execute();
    }


}
