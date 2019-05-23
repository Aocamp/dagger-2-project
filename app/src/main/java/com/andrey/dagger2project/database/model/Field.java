package com.andrey.dagger2project.database.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "fields",
        foreignKeys = @ForeignKey(
                entity = Service.class,
                parentColumns = "id",
                childColumns = "service_id"))
public class Field {
    @PrimaryKey
    private long id;
    @ColumnInfo(name = "service_id")
    private long serviceId;
    @ColumnInfo(name = "is_need_send")
    private boolean isNeedSend;

    private String name;
    private String type;
    private long sort;
    private boolean hidden;
    private boolean button;
    private boolean readonly;
    private String mask;
    private boolean unmask;
    private String title;

    @Ignore
    private List<Long> steps = null;
    @Ignore
    private Object value;
    @Ignore
    private Object validations;
    @Ignore
    private Object values;
    @Ignore
    private Object blacklist;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isNeedSend() {
        return isNeedSend;
    }

    public void setNeedSend(boolean needSend) {
        isNeedSend = needSend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
