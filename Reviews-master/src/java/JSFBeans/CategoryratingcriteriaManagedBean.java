/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.CategoryratingcriteriaJerseyClient;
import ejb.adminejbLocal;
import entity.Categoryratingcriteria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
 * @author admin
 */
@Named(value = "categoryratingcriteriaManagedBean")
@RequestScoped
public class CategoryratingcriteriaManagedBean {

    @EJB
    private adminejbLocal admin;

    CategoryratingcriteriaJerseyClient jerseyClient ;

    private int categoryratingcriteriaId, categoryId, ratingcriteriaId;
    private List<Categoryratingcriteria> categoryratingcriterias;

    public CategoryratingcriteriaManagedBean() {
        System.out.println("In Categoryratingcriteria Bean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";
        token = request.getSession().getAttribute("token").toString();
        System.out.println("token in session ="+token);
        System.out.println("Token=" + token);
        jerseyClient=new CategoryratingcriteriaJerseyClient(token);
    }

    public adminejbLocal getAdmin() {
        return admin;
    }

    public void setAdmin(adminejbLocal admin) {
        this.admin = admin;
    }

    public CategoryratingcriteriaJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(CategoryratingcriteriaJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getCategoryratingcriteriaId() {
        return categoryratingcriteriaId;
    }

    public void setCategoryratingcriteriaId(int categoryratingcriteriaId) {
        this.categoryratingcriteriaId = categoryratingcriteriaId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRatingcriteriaId() {
        return ratingcriteriaId;
    }

    public void setRatingcriteriaId(int ratingcriteriaId) {
        this.ratingcriteriaId = ratingcriteriaId;
    }

    public List<Categoryratingcriteria> getCategoryratingcriterias() {
        return categoryratingcriterias;
    }

    public void setCategoryratingcriterias(List<Categoryratingcriteria> categoryratingcriterias) {
        this.categoryratingcriterias = categoryratingcriterias;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allCategoryratingcriteria(Response.class);
        ArrayList<Categoryratingcriteria> arrayList = new ArrayList<Categoryratingcriteria>();
        GenericType<Collection<Categoryratingcriteria>> genericType = new GenericType<Collection<Categoryratingcriteria>>() {
        };
        arrayList = (ArrayList<Categoryratingcriteria>) response.readEntity(genericType);
        categoryratingcriterias = arrayList;
    }

    public String addCategoryratingcriteria() throws IOException {
        jerseyClient.addCategoryratingcriteria(categoryId + "", ratingcriteriaId + "");
        return "categoryratingcriteria.xhtml?faces-redirect=true";
    }

        public void onRowEdit(RowEditEvent<Categoryratingcriteria> event)
    {
        jerseyClient.updateCategoryratingcriteria(event.getObject().getCategoryRatingCriteriaId()+"", event.getObject().getCategoryId()+"",event.getObject().getRatingCriteriaId()+"");
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getCategoryId().getCategoryName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancelUser(RowEditEvent<Categoryratingcriteria> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getCategoryId().getCategoryName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public String deleteCategoryratingcriteria(String categoryratingcriteriaId) {
        jerseyClient.deleteCategoryratingcriteria(categoryratingcriteriaId);
        return "categoryratingcriteria.xhtml?faces-redirect=true";
    }

    public String getCategoryratingcriteria(String categoryratingcriteriaId) {
        Response response = jerseyClient.getCategoryratingcriteria(Response.class, categoryratingcriteriaId);
        GenericType<Categoryratingcriteria> genericType = new GenericType<Categoryratingcriteria>() {
        };
        Categoryratingcriteria categoryratingcriteria = response.readEntity(genericType);
        this.categoryratingcriteriaId = categoryratingcriteria.getCategoryRatingCriteriaId();
        categoryId = categoryratingcriteria.getCategoryId().getCategoryId();
        ratingcriteriaId = categoryratingcriteria.getRatingCriteriaId().getRatingCriteriaId();

        return "productrating.xhtml";
    }

    public void getCategoryratingcriteriaByCategoryId(String categoryid) {        
        categoryratingcriterias = (List<Categoryratingcriteria>) admin.getCategoryRatingCriteriaByCategoryId(categoryId);
        System.out.println(categoryratingcriterias);
    }
}
