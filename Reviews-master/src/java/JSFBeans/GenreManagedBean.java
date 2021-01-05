/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

import client.GenreJerseyClient;
import ejb.commanejbLocal;
import entity.Company;
import entity.Genre;
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
@Named(value = "genreManagedBean")
@RequestScoped
public class GenreManagedBean {

    @EJB
    private commanejbLocal comman;

    GenreJerseyClient jerseyClient;

    private int genreId;
    private String genreName;
    private List<Genre> genres;

    public GenreManagedBean() {
        System.out.println("In GenreManaged Bean ");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";
        token = request.getSession().getAttribute("token").toString();
        System.out.println("token in session =" + token);
        System.out.println("Token=" + token);
        jerseyClient = new GenreJerseyClient(token);
    }

    public commanejbLocal getComman() {
        return comman;
    }

    public void setComman(commanejbLocal comman) {
        this.comman = comman;
    }

    public GenreJerseyClient getJerseyClient() {
        return jerseyClient;
    }

    public void setJerseyClient(GenreJerseyClient jerseyClient) {
        this.jerseyClient = jerseyClient;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @PostConstruct
    public void init() {
        Response response = jerseyClient.allGenre(Response.class);
        ArrayList<Genre> arrayList = new ArrayList<Genre>();
        GenericType<Collection<Genre>> genericType = new GenericType<Collection<Genre>>() {
        };
        arrayList = (ArrayList<Genre>) response.readEntity(genericType);
        genres = arrayList;
    }

    public String addGenre() {
        if (this.genreId != 0) {
            jerseyClient.updateGenre(genreId + "", genreName);
        } else {
            jerseyClient.addGenre(genreName);
        }
        return "genre.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent<Genre> event) {
        jerseyClient.updateGenre(event.getObject().getGenreId() + "", event.getObject().getGenreName());
        FacesMessage msg = new FacesMessage("Edit Successfully", event.getObject().getGenreName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancelUser(RowEditEvent<Genre> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().getGenreName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String deleteGenre(String genreId) {
        jerseyClient.deleteGenre(genreId);
        return "genre.xhtml?faces-redirect=true";
    }

    public String getGenre(String genreId) {
        Response response = jerseyClient.getGenre(Response.class, genreId);
        GenericType<Genre> genericType = new GenericType<Genre>() {
        };
        Genre genre = response.readEntity(genericType);
        this.genreId = genre.getGenreId();
        genreName = genre.getGenreName();

        return "addgenre.xhtml";
    }
}
