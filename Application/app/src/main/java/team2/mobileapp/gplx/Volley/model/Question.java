package team2.mobileapp.gplx.Volley.model;

import java.io.Serializable;

public class Question implements Serializable {

    private String id;
    private int index;
    private String query;
    private String photo;
    private String licenseId;
    private String questionSetId;
    private String questionTypeId;

    public Question(int index, String query, String photo, String licenseId,String questionSetId, String questionTypeId) {
        super();
        this.index = index;
        this.query = query;
        this.photo = photo;
        this.licenseId = licenseId;
        this.questionSetId = questionSetId;
        this.questionTypeId = questionTypeId;
    }

    public Question() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getQuestionSetId() {
        return questionSetId;
    }

    public void setQuestionSetId(String questionSetId) {
        this.questionSetId = questionSetId;
    }

    public String getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", index=" + index +
                ", query='" + query + '\'' +
                ", photo='" + photo + '\'' +
                ", licenseId='" + licenseId + '\'' +
                ", questionSetId='" + questionSetId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                '}';
    }
}
