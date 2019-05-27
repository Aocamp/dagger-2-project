package com.andrey.dagger2project.database.entity;

import android.arch.persistence.room.PrimaryKey;

public class BaseModel {
    @PrimaryKey
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
