package com.andrey.dagger2project.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(foreignKeys = @ForeignKey(entity = Service.class, parentColumns = "id", childColumns = "serviceId"))
public class Category extends BaseModel{
    @SerializedName("parent_id")
    @Expose
    private long parentId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("parent")
    @Expose
    @Ignore
    private Object parent;
    @SerializedName("children")
    @Expose
    @Ignore
    private Object children;
    @SerializedName("blacklist")
    @Expose
    @Ignore
    private Object blacklist;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("picture_url")
    @Expose
    private String pictureUrl;
    @ColumnInfo(index = true)
    private long serviceId;

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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
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

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
