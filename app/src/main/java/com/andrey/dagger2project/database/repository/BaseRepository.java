package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.andrey.dagger2project.database.AppDatabase;
import com.andrey.dagger2project.database.dao.BaseDao;
import com.andrey.dagger2project.database.model.BaseModel;

import java.util.List;

public abstract class BaseRepository<T extends BaseModel> {
    private BaseDao dao;

    public void insert (T t){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dao.insert(t);
                return null;
            }
        }.execute();
    }

    public void insertAll (List<T> t){
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dao.insertAll(t);
                return null;
            }
        }.execute();
    }

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
