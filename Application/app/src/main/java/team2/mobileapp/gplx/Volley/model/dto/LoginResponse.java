package team2.mobileapp.gplx.Volley.model.dto;

public class LoginResponse {
    private String id;

    private String username;

    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Id=" + id + " " + "RoleId=" + roleId + " " +"Username=" + username;
    }
}
