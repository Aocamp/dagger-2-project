package com.andrey.dagger2project.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class a {
    @PrimaryKey
    private long id;
    private long serviceCategoryId;
    private long subcategoryId;
    private long serviceId;
}
