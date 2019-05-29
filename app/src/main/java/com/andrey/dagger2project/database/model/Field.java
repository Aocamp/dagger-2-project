package com.andrey.dagger2project.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(foreignKeys = {
        @ForeignKey(entity = Service.class, parentColumns = "id", childColumns = "serviceId"),
        @ForeignKey(entity = SubService.class, parentColumns = "id", childColumns = "serviceId") })
public class Field extends BaseModel {
    @SerializedName("service_id")
    @Expose
    @ColumnInfo(index = true)
    private long serviceId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("sort")
    @Expose
    private long sort;
    @SerializedName("hidden")
    @Expose
    private boolean hidden;
    @SerializedName("button")
    @Expose
    private boolean button;
    @SerializedName("readonly")
    @Expose
    private boolean readonly;
    @SerializedName("mask")
    @Expose
    private String mask;
    @SerializedName("unmask")
    @Expose
    private boolean unmask;
    @SerializedName("value")
    @Expose
    @Ignore
    private Object value;
    @SerializedName("steps")
    @Expose
    @Ignore
    private List<Long> steps = null;
    @SerializedName("validations")
    @Expose
    @Ignore
    private Object validations;
    @SerializedName("values")
    @Expose
    @Ignore
    private Object values;
    @SerializedName("blacklist")
    @Expose
    @Ignore
    private Object blacklist;
    @SerializedName("is_need_send")
    @Expose
    private boolean isNeedSend;
    @SerializedName("title")
    @Expose
    private String title;

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSort() {
        return sort;
    }

    public void setSort(long sort) {
        this.sort = sort;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isButton() {
        return button;
    }

    public void setButton(boolean button) {
        this.button = button;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public boolean isUnmask() {
        return unmask;
    }

    public void setUnmask(boolean unmask) {
        this.unmask = unmask;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<Long> getSteps() {
        return steps;
    }

    public void setSteps(List<Long> steps) {
        this.steps = steps;
    }

    public Object getValidations() {
        return validations;
    }

    public void setValidations(Object validations) {
        this.validations = validations;
    }

    public Object getValues() {
        return values;
    }

    public void setValues(Object values) {
        this.values = values;
    }

    public Object getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Object blacklist) {
        this.blacklist = blacklist;
    }

    public boolean isIsNeedSend() {
        return isNeedSend;
    }

    public void setIsNeedSend(boolean isNeedSend) {
        this.isNeedSend = isNeedSend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
