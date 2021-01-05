/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.UserroleJerseyClient;
import ejb.adminejbLocal;
import entity.Userrole;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.event.RowEditEvent;


/**
 *
 * @author hi
 */
@Named(value = "userRoleManagedBean")
@RequestScoped
public class UserRoleManagedBean {

    /**
     * Creates a new instance of UserRoleManagedBean
     */
    
    UserroleJerseyClient urjc;
    @EJB adminejbLocal admin;
    private int userroleid,userid,roleid;
    private Collection<Userrole> userRoleList;

    public UserRoleManagedBean() {
        System.out.println("In UserRoleManaged Bean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";
        token = request.getSession().getAttribute("token").toString();
        System.out.println("token in session ="+token);
        System.out.println("Token=" + token);
        urjc=new UserroleJerseyClient(token);
    }
    
    public int getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(int userroleid) {
        this.userroleid = userroleid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Collection<Userrole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(Collection<Userrole> userRoleList) {
        this.userRoleList = userRoleList;
    }
    
    
    @PostConstruct
    public void init()
    {
        Response response = urjc.getAllUserrole(Response.class);
        ArrayList<Userrole> alist = new ArrayList<Userrole>();
        GenericType<Collection<Userrole>> gur=new GenericType<Collection<Userrole>>(){};
        userRoleList=response.readEntity(gur);
//        userRoleList=admin.getAllUserRole();
//        System.out.println(userRoleList);
    }
    
    public String addUserRole()
    {
        System.out.println("in add");
        System.out.println(" user "+userid+" role "+roleid);
//        urjc.addUserRole(userid+"", roleid+"");
        admin.addUserRole(userid, roleid);
        return "/Admin/userroleindex.xhtml?faces-redirect=true";
    }
    
    
    public void onRowEditRole(RowEditEvent<Userrole> event) {
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getUserId().getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
//        urjc.updateUserRole(event.getObject().getUserRoleId()+"", event.getObject().getUserId().getUserId()+"", event.getObject().getRoleId().getRoleId()+"");
        admin.updateUserRole(event.getObject().getUserRoleId(), event.getObject().getUserId().getUserId(), event.getObject().getRoleId().getRoleId());
    }

    public void onRowCancelRole(RowEditEvent<Userrole> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getUserId().getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String deleteUserRole(int id)
    {
        System.out.println("userroleid "+id);
        //urjc.deleteUserrole(id+"");
        admin.removeUserRole(id);
        return "/Admin/userroleindex.xhtml?faces-redirect=true";
    }
}
