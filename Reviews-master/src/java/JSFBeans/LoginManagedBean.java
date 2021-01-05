/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hi
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable{

    @Inject
    SecurityContext sc;
    private String email, pass, message;
    private Set<String> roles;
    private AuthenticationStatus status;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SecurityContext getSc() {
        return sc;
    }

    public void setSc(SecurityContext sc) {
        this.sc = sc;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    
    
    public LoginManagedBean() {
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
    
    public String Login() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            request.getSession().setAttribute("role", "");
//            Credential credential = new UsernamePasswordCredential(username, password);

            Credential credential = new UsernamePasswordCredential(email, new Password(pass));
            AuthenticationStatus status = sc.authenticate(request, response,withParams().credential(credential));
            // if(status.equals(SUCCESS)) {
            if (status.equals(SEND_CONTINUE)) {
                // Authentication mechanism has send a redirect, should not
                // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
                context.responseComplete();
            }

            //      else if (status.equals(SEND_FAILURE)) {
//            message = "Login Failed";
//            System.out.println(message);
//            addError(context, "Authentication failed");
//        }
            if (roles.contains("Admin")) {
                System.out.println("In admin");
                request.getSession().setAttribute("role", "Admin");
                return "/Admin/userindex.xhtml?faces-redirect=true";
            } else if (roles.contains("User")) {
                System.out.println("In User");
                request.getSession().setAttribute("role", "User");
                return "/User/productclient.xhtml?faces-redirect=true";
            }

            //} 
        } catch (Exception e) {
            message = "Out- Either user or login is wrong !!!";
            e.printStackTrace();
        }
        return "Login.xhtml";
    }

    public String logout() throws ServletException {
        System.out.println("In Log out");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().setAttribute("role", "");
        request.getSession().invalidate();
        request.logout();
        return "/Login.xhtml?faces-redirect=true";
    }
    
    
    
}
