package team2.mobileapp.gplx.Retrofit.models;

public class HistoricalExam {
    private String userid;
    private String license;
    private String setname;
    private String date;
    private int correct;
    private int total;

    public HistoricalExam() {
    }

    public HistoricalExam(String userid, String license, String setname, String date, int correct, int total) {
        this.userid = userid;
        this.license = license;
        this.setname = setname;
        this.date = date;
        this.correct = correct;
        this.total = total;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getSetname() {
        return setname;
    }

    public void setSetname(String setname) {
        this.setname = setname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
