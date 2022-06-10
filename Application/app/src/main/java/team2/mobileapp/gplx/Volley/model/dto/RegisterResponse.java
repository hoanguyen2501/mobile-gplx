package team2.mobileapp.gplx.Volley.model.dto;

public class RegisterResponse {
    private String email;
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Email=" + email + " " + "username=" + username;
    }
}
