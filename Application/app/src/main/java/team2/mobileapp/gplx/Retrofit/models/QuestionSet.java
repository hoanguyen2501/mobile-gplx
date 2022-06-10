package team2.mobileapp.gplx.Retrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuestionSet implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Status")
    @Expose
    private boolean status;

    @SerializedName("Quantity")
    @Expose
    private int quantity;

    @SerializedName("LicenseId")
    @Expose
    private String licenseId;

    public QuestionSet(){}

    public QuestionSet(String id, String name, boolean status, int quantity, String licenseId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.quantity = quantity;
        this.licenseId = licenseId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }
}
