package team2.mobileapp.gplx.Volley.model;

public class QuestionViewList {

    private String id;
    private int index;
    private String query;
    private boolean isTop50;
    private String photo;
    private String licenseId;
    private String questionSetId;
    private String questionTypeId;

    public QuestionViewList(int index, String query, boolean isTop50, String photo, String licenseId,String questionSetId, String questionTypeId) {
        super();
        this.index = index;
        this.query = query;
        this.isTop50 = isTop50;
        this.photo = photo;
        this.licenseId = licenseId;
        this.questionSetId = questionSetId;
        this.questionTypeId = questionTypeId;
    }

    public QuestionViewList() {

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

    public boolean isTop50() {
        return isTop50;
    }

    public void setTop50(boolean isTop50) {
        this.isTop50 = isTop50;
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
                ", isTop50=" + isTop50 +
                ", photo='" + photo + '\'' +
                ", licenseId='" + licenseId + '\'' +
                ", questionSetId='" + questionSetId + '\'' +
                ", questionTypeId='" + questionTypeId + '\'' +
                '}';
    }
}
