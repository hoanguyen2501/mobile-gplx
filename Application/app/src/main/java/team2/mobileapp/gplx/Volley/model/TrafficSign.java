package team2.mobileapp.gplx.Volley.model;

public class TrafficSign {
    private String id;
    private String Code;
    private String Name;
    private String Description;
    private String Photo;
    private String TrafficSignType;

    public TrafficSign() {
    }

    public TrafficSign(String id, String code, String name, String description, String photo, String trafficSignType) {
        this.id = id;
        this.Code = code;
        this.Name = name;
        this.Description = description;
        this.Photo = photo;
        this.TrafficSignType = trafficSignType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        this.Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        this.Photo = photo;
    }

    public String getTrafficSignType() {
        return TrafficSignType;
    }

    public void setTrafficSignType(String trafficSignType) {
        this.TrafficSignType = trafficSignType;
    }

    @Override
    public String toString() {
        return "TrafficSign{" +
                "id='" + id + '\'' +
                ", code='" + Code + '\'' +
                ", name='" + Name + '\'' +
                ", description='" + Description + '\'' +
                ", photo='" + Photo + '\'' +
                ", trafficSignType='" + TrafficSignType + '\'' +
                '}';
    }
}
