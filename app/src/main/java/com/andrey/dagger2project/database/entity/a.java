package com.andrey.dagger2project.database.entity;

import android.arch.persistence.room.Entity;

@Entity(tableName = "")
public class a extends BaseModel{
    private long serviceCategoryId;
    private long serviceId;

    public long getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(long serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
