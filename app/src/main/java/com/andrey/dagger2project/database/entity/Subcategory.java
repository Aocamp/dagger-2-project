package com.andrey.dagger2project.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;

@Entity(tableName = "subcategories", foreignKeys = @ForeignKey(entity = ServiceCategory.class, parentColumns = "id", childColumns = "parentId"))
public class Subcategory extends BaseModel {
    @ColumnInfo(index = true)
    private long parentId;
    private String pictureUrl;
    private String title;
    private String name;
    private String language;
    @Ignore
    private Object picture;
    @Ignore
    private Object parent;
    @Ignore
    private Object children;
    @Ignore
    private Object blacklist;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public Object getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Object blacklist) {
        this.blacklist = blacklist;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
