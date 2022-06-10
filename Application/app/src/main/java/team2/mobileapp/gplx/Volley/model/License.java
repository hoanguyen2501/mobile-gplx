package team2.mobileapp.gplx.Volley.model;

public class License {
    private String id;
    private String name;
    private String status;
    private String desciption;

    public License(String id, String name, String status, String desciption) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.desciption = desciption;
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

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "id='" + id + ", name='" + name + ", status='" + status + ", desciption='" + desciption;
    }
}
