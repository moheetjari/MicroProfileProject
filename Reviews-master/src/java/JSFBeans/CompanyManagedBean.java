/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.CompanyJerseyClient;
import ejb.commanejbLocal;
import entity.Company;
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
@Named(value = "companyManagedBean")
@RequestScoped
public class CompanyManagedBean {

    @EJB
    private commanejbLocal comman;

    CompanyJerseyClient jerseyClient ;

    private int companyId;
    private String companyName;
    private List<Company> companys;

    public CompanyManagedBean() {
        System.out.println("In CompanyManaged Bean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";
        token = request.getSession().getAttribute("token").toString();
        System.out.println("token in session ="+token);
        System.out.println("Token=" + token);
        jerseyClient=new CompanyJerseyClient(token);
    }

    public commanejbLocal getComman() {
        return comman;
    }

    public void setComman(commanejbLocal comman) {
        this.comman = comman;
    }

    public CompanyJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(CompanyJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Company> getCompanys() {
        return companys;
    }

    public void setCompanys(List<Company> companys) {
        this.companys = companys;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allCompany(Response.class);
        ArrayList<Company> arrayList = new ArrayList<Company>();
        GenericType<Collection<Company>> genericType = new GenericType<Collection<Company>>() {
        };
        arrayList = (ArrayList<Company>) response.readEntity(genericType);
        companys = arrayList;
    }

    public String addCompany() {
        if (this.companyId != 0) {
            jerseyClient.updateCompany(companyId + "", companyName);
        } else {
            jerseyClient.addCompany(companyName);
        }
        return "company.xhtml?faces-redirect=true";
    }
    
    public void onRowEdit(RowEditEvent<Company> event)
    {
        jerseyClient.updateCompany(event.getObject().getCompanyId()+"", event.getObject().getCompanyName());
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getCompanyName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancelUser(RowEditEvent<Company> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getCompanyName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String deleteCompany(String companyId) {
        jerseyClient.deleteCompany(companyId);
        return "company.xhtml?faces-redirect=true";
    }

    public String getCompany(String companyId) {
        Response response = jerseyClient.getCompany(Response.class, companyId);
        GenericType<Company> genericType = new GenericType<Company>() {
        };
        Company company = response.readEntity(genericType);
        this.companyId = company.getCompanyId();
        companyName = company.getCompanyName();

        return "addcompany.xhtml";
    }
}
