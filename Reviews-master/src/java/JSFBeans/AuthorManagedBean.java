/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.AuthorJerseyClient;
import ejb.commanejbLocal;
import entity.Author;
import java.io.Serializable;
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
@Named(value = "authorManagedBean")
@RequestScoped
public class AuthorManagedBean implements Serializable {

    @EJB
    private commanejbLocal comman;

    AuthorJerseyClient jerseyClient;

    private int authorId;
    private String authorName;
    private List<Author> authors;

    public AuthorManagedBean() {
        System.out.println("In Author Bean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";
        token = request.getSession().getAttribute("token").toString();
        System.out.println("token in session =" + token);
        System.out.println("Token=" + token);
        jerseyClient = new AuthorJerseyClient(token);

    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allAuthor(Response.class);
        ArrayList<Author> arrayList = new ArrayList<Author>();
        GenericType<Collection<Author>> genericType = new GenericType<Collection<Author>>() {
        };
        arrayList = (ArrayList<Author>) response.readEntity(genericType);
        authors = arrayList;
    }

    public commanejbLocal getComman() {
        return comman;
    }

    public void setComman(commanejbLocal comman) {
        this.comman = comman;
    }

    public AuthorJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(AuthorJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String addAuthor() {
        if (this.authorId != 0) {
            jerseyClient.updateAuthor(authorId + "", authorName);
        } else {
            jerseyClient.addAuthor(authorName);
        }
        return "author.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent<Author> event) {
        jerseyClient.updateAuthor(event.getObject().getAuthorId()+ "", event.getObject().getAuthorName());
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getAuthorName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancelUser(RowEditEvent<Author> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getAuthorName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String deleteAuthor(String authorId) {
        jerseyClient.deleteAuthor(authorId);
        return "author.xhtml?faces-redirect=true";
    }

    public String getAuthor(String authorId) {
        Response response = jerseyClient.getAuthor(Response.class, authorId);
        GenericType<Author> genericType = new GenericType<Author>() {
        };
        Author author = response.readEntity(genericType);
        this.authorId = author.getAuthorId();
        authorName = author.getAuthorName();

        return "addauthor.xhtml";
    }

}
