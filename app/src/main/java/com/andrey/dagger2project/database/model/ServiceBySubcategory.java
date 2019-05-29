package com.andrey.dagger2project.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = Service.class, parentColumns = "id", childColumns = "serviceId"),
        @ForeignKey(entity = Subcategory.class, parentColumns = "id", childColumns = "subcategoryId")})
public class ServiceBySubcategory extends BaseModel{
    @ColumnInfo(index = true)
    private long subcategoryId;
    @ColumnInfo(index = true)
    private long serviceId;


    public long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
