package team2.mobileapp.gplx.Retrofit.models;

public class Question {

    private String id;
    private int Index;
    private String Query;
    private boolean IsTop50;
    private String Photo;
    private String LicenseId;
    private String QuestionSetId;
    private String QuestionTypeId;

    public Question(int index, String query, boolean isTop50, String photo, String licenseId,String questionSetId, String questionTypeId) {
        super();
        this.Index = index;
        this.Query = query;
        this.IsTop50 = isTop50;
        this.Photo = photo;
        this.LicenseId = licenseId;
        this.QuestionSetId = questionSetId;
        this.QuestionTypeId = questionTypeId;
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
        return Index;
    }

    public void setIndex(int index) {
        this.Index = index;
    }

    public String getQuery() {
        return Query;
    }

    public void setQuery(String query) {
        this.Query = query;
    }

    public boolean isTop50() {
        return IsTop50;
    }

    public void setTop50(boolean isTop50) {
        this.IsTop50 = isTop50;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        this.Photo = photo;
    }

    public String getLicenseId() {
        return LicenseId;
    }

    public void setLicenseId(String licenseId) {
        this.LicenseId = licenseId;
    }

    public String getQuestionSetId() {
        return QuestionSetId;
    }

    public void setQuestionSetId(String questionSetId) {
        this.QuestionSetId = questionSetId;
    }

    public String getQuestionTypeId() {
        return QuestionTypeId;
    }

    public void setQuestionTypeId(String questionTypeId) {
        this.QuestionTypeId = questionTypeId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", index=" + Index +
                ", query='" + Query + '\'' +
                ", isTop50=" + IsTop50 +
                ", photo='" + Photo + '\'' +
                ", licenseId='" + LicenseId + '\'' +
                ", questionSetId='" + QuestionSetId + '\'' +
                ", questionTypeId='" + QuestionTypeId + '\'' +
                '}';
    }
}
