package com.lenovo.bean;

import com.lenovo.dao.LoginDAO;
import com.lenovo.dao.SessionUtils;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
@Named(value = "login")
@ManagedBean
@SessionScoped
public class Login implements Serializable {
    private static final long serialVersionUID = 1094801825228386363L;
    
    private String password;
    private String message;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String validateUsernamePassword(){
        boolean valid = LoginDAO.validate(username, password);
        if (valid) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", username);
                return "dashboard";
        }else if(username.equals("") && password.equals("")){
                message = "Username and Password cannot be empty";
                return "index";
        }else if(username.equals("")){
                message = "Username cannot be empty";
                return "index";
        }else if(password.equals("")){
                message = "Password cannot be empty";
                return "index";
        }else {
//                FacesContext.getCurrentInstance().addMessage(
//                null,
//                new FacesMessage(FacesMessage.SEVERITY_WARN,
//                "Incorrect Username or Passowrd",
//                "Please enter correct username and Password"));
                message = "Incorrect Username or Passowrd";
                return "index";
        }
    }
    
    //logout event, invalidate session
    public String logout() {
            HttpSession session = SessionUtils.getSession();
            session.invalidate();
            return "index?faces-redirect=true";
    }
}
