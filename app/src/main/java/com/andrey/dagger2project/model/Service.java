package com.andrey.dagger2project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Service {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("parent_id")
    @Expose
    private Object parentId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("description_company")
    @Expose
    private String descriptionCompany;
    @SerializedName("commission_info")
    @Expose
    private String commissionInfo;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("synonyms")
    @Expose
    private List<String> synonyms = null;
    @SerializedName("type")
    @Expose
    private long type;
    @SerializedName("status")
    @Expose
    private long status;
    @SerializedName("template")
    @Expose
    private String template;
    @SerializedName("is_simple")
    @Expose
    private boolean isSimple;
    @SerializedName("priority")
    @Expose
    private long priority;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("fields")
    @Expose
    private List<Field> fields = null;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;
    @SerializedName("children")
    @Expose
    private Object children;
    @SerializedName("parent")
    @Expose
    private Object parent;
    @SerializedName("blacklist")
    @Expose
    private boolean blacklist;
    @SerializedName("picture_url")
    @Expose
    private String pictureUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionCompany() {
        return descriptionCompany;
    }

    public void setDescriptionCompany(String descriptionCompany) {
        this.descriptionCompany = descriptionCompany;
    }

    public String getCommissionInfo() {
        return commissionInfo;
    }

    public void setCommissionInfo(String commissionInfo) {
        this.commissionInfo = commissionInfo;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public boolean isIsSimple() {
        return isSimple;
    }

    public void setIsSimple(boolean isSimple) {
        this.isSimple = isSimple;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public boolean isBlacklist() {
        return blacklist;
    }

    public void setBlacklist(boolean blacklist) {
        this.blacklist = blacklist;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
