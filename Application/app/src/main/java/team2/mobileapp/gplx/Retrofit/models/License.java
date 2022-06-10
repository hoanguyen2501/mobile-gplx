package team2.mobileapp.gplx.Retrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class License implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("LicenseTypeId")
    @Expose
    private String licenseTypeId;

    public License(String id, String name, String status, String description, String licenseTypeId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.description = description;
        this.licenseTypeId = licenseTypeId;
    }

    public License() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicenseTypeId() {
        return licenseTypeId;
    }

    public void setLicenseTypeId(String licenseTypeId) {
        this.licenseTypeId = licenseTypeId;
    }

    @Override
    public String toString() {
        return "License{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", licenseTypeId='" + licenseTypeId + '\'' +
                '}';
    }
}
