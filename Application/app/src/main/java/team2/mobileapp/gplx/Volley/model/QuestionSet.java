package team2.mobileapp.gplx.Volley.model;

import java.io.Serializable;

public class QuestionSet implements Serializable {
    private String id;
    private String name;
    private boolean status;
    private int quantity;
    private String licenseId;

    public QuestionSet() {
    }

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
