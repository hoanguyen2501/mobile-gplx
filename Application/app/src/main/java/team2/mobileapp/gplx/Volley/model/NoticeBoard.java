package team2.mobileapp.gplx.Volley.model;

public class NoticeBoard {
    private String id;
    private String type;
    private String boardCode;
    private String boardName;
    private String boardDescription;
    private String photo;
    public NoticeBoard( String boardName) {
        this.boardName = boardName;
    }
    public NoticeBoard() {
        this.id="";
        this.type="";
        this.boardCode="No code";
        this.boardName="No name";
        this.boardDescription="No description";
        this.photo="";
    }
    public NoticeBoard(String id, String type, String boardCode, String boardName, String boardDescription, String photo) {
        this.id=id;
        this.type=type;
        this.boardCode=boardCode;
        this.boardName=boardName;
        this.boardDescription=boardDescription;
        this.photo=photo;
    }
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getBoardDescription() {
        return boardDescription;
    }

    public void setBoardDescription(String boardDescription) {
        this.boardDescription = boardDescription;
    }

    public String getBoardCode() {
        return boardCode;
    }

    public void setBoardCode(String boardCode) {
        this.boardCode = boardCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "NoticeBoard{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", boardCode='" + boardCode + '\'' +
                ", boardName='" + boardName + '\'' +
                ", boardDescription='" + boardDescription + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
