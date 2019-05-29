package com.andrey.dagger2project.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(foreignKeys = {
        @ForeignKey(entity = ServiceCategory.class, parentColumns = "id", childColumns = "serviceCategoryId"),
        @ForeignKey(entity = Subcategory.class, parentColumns = "id", childColumns = "subcategoryId")})
public class SubcategoryByCategory extends BaseModel{
    @ColumnInfo(index = true)
    private long serviceCategoryId;
    @ColumnInfo(index = true)
    private long subcategoryId;


    public long getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(long serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    public long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
