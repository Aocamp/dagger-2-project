package com.andrey.dagger2project.database.repository;

import android.os.AsyncTask;

import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.model.Subcategory;

import java.util.List;

import javax.inject.Inject;

public class SubcategoryRepository extends BaseRepository<Subcategory> {
    private SubcategoryDao dao;

    @Inject
    public SubcategoryRepository(SubcategoryDao dao){
        this.dao = dao;
    }


    public List<Subcategory> getAll() {
        return dao.getAll();
    }

    public List<Subcategory> getAllByCategoryId(Long id) {
        return new GetByIdTask(id).dao.getAllByCategoryId(id);
    }

    public static class GetByIdTask extends AsyncTask<Void, Void, Void>
    {
        private SubcategoryDao dao;
        private Long id;

        public GetByIdTask(Long id){
            this.id = id;
        }

        @Override
        protected Void doInBackground(Void... v) {
            dao.getAllByCategoryId(id);
            return null;
        }

        protected void onPostExecute(Void response)
        {

        }

    }
}
