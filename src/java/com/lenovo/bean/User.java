package com.lenovo.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "user")
@ManagedBean
@SessionScoped
public class User implements Serializable{
    private static final long serialVersionUID = 1094801825228386363L;
    
    private String username;
    private String password;
    private String comfirmpassword;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComfirmpassword() {
        return comfirmpassword;
    }

    public void setComfirmpassword(String comfirmpassword) {
        this.comfirmpassword = comfirmpassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String addUser() throws ClassNotFoundException, SQLException{
        if(username.equals("") && password.equals("") && comfirmpassword.equals("")){
            message = "Fields Can't be empty";
            return "register";
        }else if(!password.equals(comfirmpassword)){
            message = "Password doesn't match";
            return "register";
        }else if(password.equals("")){
            message = "Password can't be empty";
            return "register";
        }else if(comfirmpassword.equals("")){
            message = " Comfrim Password can't be empty";
            return "register";
        }else if(username.equals("") && !password.equals(comfirmpassword)){
            message = "Username can't be empty";
            return "register";
        }else{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lenovo", "root", "" );
            Statement ps = con.createStatement();
            ps.executeUpdate("INSERT INTO users (username, password) VALUES ('"+username+"','"+password+"')");
            message = "New User Created";
            return "register";
        }
    }
    
}
