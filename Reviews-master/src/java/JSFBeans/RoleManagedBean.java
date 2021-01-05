/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.RoleJerseyClient;
import ejb.adminejbLocal;
import entity.Role;
import entity.Users;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author hi
 */
@Named(value = "roleManagedBean")
@RequestScoped
public class RoleManagedBean {

    /**
     * Creates a new instance of RoleManagedBean
     */
    @EJB
    adminejbLocal admin;

    RoleJerseyClient rjc;
    private String rolename;
    private int roleid;
    private String sessionEmail;
    private Collection<Role> lrole;

    public RoleManagedBean() {
        System.out.println("in Role Bean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";
        token = request.getSession().getAttribute("token").toString();
        System.out.println("token in session =" + token);
        System.out.println("Token=" + token);
        rjc = new RoleJerseyClient(token);
        initWithoutPC();
    }

    public void initWithoutPC() {
        System.out.println("in init");
        Response response = rjc.getAllRoles(Response.class);
        ArrayList<Role> rlistaray = new ArrayList<Role>();
        GenericType<Collection<Role>> gRole = new GenericType<Collection<Role>>() {};
        lrole=(ArrayList<Role>)response.readEntity(gRole);
    }

//    @PostConstruct
//    public void init() {
////        System.out.println("in init");
////        Response response = rjc.getAllRoles(Response.class);
////        ArrayList<Role> rlista = new ArrayList<Role>();
////        GenericType<Collection<Role>> gRole = new GenericType<Collection<Role>>() {};
////        rlist = (ArrayList<Role>) response.readEntity(gRole);
////        rlist = admin.getAllRoles();
////        System.out.println(rlist);
//    }

    public Collection<Role> getLrole() {
        return lrole;
    }

    public void setLrole(Collection<Role> lrole) {
        this.lrole = lrole;
    }
    
    
    

    public String getSessionEmail() {
        return sessionEmail;
    }

    public void setSessionEmail(String sessionEmail) {
        this.sessionEmail = sessionEmail;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

//    public Collection<Role> getAllRoles() {
//        Response response = rjc.getAllRoles(Response.class);
//        ArrayList<Role> rlist = new ArrayList<Role>();
//        GenericType<ArrayList<Role>> gRole = new GenericType<ArrayList<Role>>() {
//        };
//        rlist = response.readEntity(gRole);
//        return rlist;
//    }
    public String getRoleById(int id) {
//        Response response = rjc.getRoleById(Response.class, id + "");
//        GenericType<Role> gRole = new GenericType<Role>() {
//        };
//        Role role = response.readEntity(gRole);
        Role role = admin.getRoleById(id);
        roleid = role.getRoleId();
        rolename = role.getRoleName();
        return "";
    }

    public String addRole() {
        if (roleid != 0) {
            rjc.updateRole(roleid + "", rolename);
        } else {
            admin.addRole(rolename);
            //rjc.addRole(rolename);
        }
        return "/Admin/Roleindex.xhtml?faces-redirect=true";
    }

    public void onRowEditRole(RowEditEvent<Role> event) {
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getRoleName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
//        rjc.updateRole(event.getObject().getRoleId() + "", event.getObject().getRoleName());
        admin.updateRole(event.getObject().getRoleId(), event.getObject().getRoleName());
    }

    public void onRowCancelRole(RowEditEvent<Role> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getRoleName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String deleteRole(int id) {
        System.out.println("in delete");
        System.out.println(id);
        //rjc.deleteRole(id + "");
        admin.removeRole(id);
        return "/Admin/Roleindex.xhtml?faces-redirect=true";
    }

    public void logout() throws IOException {
        System.out.println("in logout");
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//        ec.invalidateSession();
//        ec.redirect(ec.getRequestContextPath() + "/Login.xhtml");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpSession session = request.getSession(false);
        try {
            session.invalidate();
            request.logout();
            response.sendRedirect(request.getContextPath() + "/Login.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public String Logout()
//    {
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpSession session = request.getSession(true);
//        try {
//            session.invalidate();
//            request.logout();
//            return "/index.xhtml";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        return null;
//    }

//    @PostConstruct
//    public void init() {
//        System.out.println("in role init");
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            System.out.println("session null");
//        } else {
//            System.out.println("session not null");
//        }
//        try {
//            if (session.getAttribute("Admin") == "" || session.getAttribute("Admin") == null) {
//                response.sendRedirect(request.getContextPath() + "/Login.xhtml");
//            } else {
//                setSessionEmail(session.getAttribute("Admin").toString());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
