package test.shop.model;

import java.util.Date;

/**
 * @Author : jasonzii @Author
 * @Description :
 * @CreateDate : 18.3.16  14:46
 */
public class User {


    private String email;
    private String password;
    private String username;
    private String repassword;
    private int status;


    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
