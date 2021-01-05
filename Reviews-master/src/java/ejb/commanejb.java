/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Author;
import entity.Company;
import entity.Genre;
import entity.Publisher;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hi
 */
@Stateless
public class commanejb implements commanejbLocal {

//    @PersistenceContext(unitName = "MyReview")
    EntityManager em;

    @PostConstruct
    public void init() {
        em = Persistence.createEntityManagerFactory("MyReview").createEntityManager();
    }

    // <editor-fold defaultstate="collapsed" desc="Author">
    @Override
    public void addAuthor(String AuthorName) {
        Author a = new Author();
        a.setAuthorName(AuthorName);
//        em.persist(a);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }

    @Override
    public void updateAuthor(int AuthorId, String AuthorName) {
        Author auth = em.find(Author.class, AuthorId);
        auth.setAuthorName(AuthorName);
//        em.merge(auth);
        em.getTransaction().begin();
        em.merge(auth);
        em.getTransaction().commit();
    }

    @Override
    public Author getAuthorByName(String AuthorName) {
        Collection<Author> authors = em.createNamedQuery("Author.findByAuthorName")
                .setParameter("authorName", AuthorName)
                .getResultList();

        return (Author) authors;
    }

    @Override
    public Collection<Author> getAllAuthor() {
        Collection<Author> list = em.createNamedQuery("Author.findAll").getResultList();
        System.out.println(list);
        return list;
    }

    @Override
    public void removeAuthor(int AuthorId) {
        Author a = em.find(Author.class, AuthorId);
//        em.remove(a);
        em.getTransaction().begin();
        em.remove(a);
        em.getTransaction().commit();
    }

    @Override
    public Author getAuthorById(int AuthorId) {
        return (Author) em.find(Author.class, AuthorId);
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Company">
    @Override
    public void addCompany(String CompanyName) {
        Company company = new Company();
        company.setCompanyName(CompanyName);

//        em.persist(company);
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
    }

    @Override
    public void updateComapany(int CompanyId, String CompanyName) {
        Company company = (Company) em.find(Company.class, CompanyId);
        company.setCompanyName(CompanyName);
//        em.merge(company);
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
    }

    @Override
    public void removeCompany(int CompanyId) {
        Company company = (Company) em.find(Company.class, CompanyId);
//        em.remove(company);
        em.getTransaction().begin();
        em.remove(company);
        em.getTransaction().commit();
    }

    @Override
    public Company getCompanuById(int CompanyId) {
        return (Company) em.find(Company.class, CompanyId);
    }

    @Override
    public Company getCompanyByName(String CompanyName) {
        Collection<Company> companys = em.createNamedQuery("Company.findByCompanyName")
                .setParameter("companyName", CompanyName)
                .getResultList();

        return (Company) companys;
    }

    @Override
    public Collection<Company> getAllCompany() {
        return em.createNamedQuery("Company.findAll").getResultList();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Genre">
    @Override
    public void addGenre(String GenreName) {
        Genre genre = new Genre();
        genre.setGenreName(GenreName);
        
//        em.persist(genre);
        em.getTransaction().begin();
        em.persist(genre);
        em.getTransaction().commit();
    }

    @Override
    public void updateGenre(int GenreId, String GenreName) {
        Genre genre = em.find(Genre.class, GenreId);
        genre.setGenreName(GenreName);
//        em.merge(genre);
        em.getTransaction().begin();
        em.merge(genre);
        em.getTransaction().commit();
    }

    @Override
    public void removeGenre(int GenreId) {
        Genre genre = em.find(Genre.class, GenreId);
//        em.remove(genre);
        em.getTransaction().begin();
        em.remove(genre);
        em.getTransaction().commit();
    }

    @Override
    public Genre getGenreById(int GenreId) {
        return (Genre) em.find(Genre.class, GenreId);
    }

    @Override
    public Genre getGenreByName(String GenreName) {
        Collection<Genre> genres = em.createNamedQuery("Genre.findByGenreName")
                .setParameter("genreName", GenreName)
                .getResultList();

        return (Genre) genres;
    }

    @Override
    public Collection<Genre> getAllGenre() {
        return em.createNamedQuery("Genre.findAll").getResultList();
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Publisher">
    @Override
    public void addPublisher(String PublisherName) {
        Publisher publisher = new Publisher();
        publisher.setPublisherName(PublisherName);
//        em.persist(publisher);
        em.getTransaction().begin();
        em.persist(publisher);
        em.getTransaction().commit();
    }

    @Override
    public void updatePublisher(int PublisherId, String PublisherName) {
        Publisher publisher = (Publisher) em.find(Publisher.class, PublisherId);
        publisher.setPublisherName(PublisherName);
//        em.merge(publisher);
        em.getTransaction().begin();
        em.merge(publisher);
        em.getTransaction().commit();
    }

    @Override
    public void removePublisher(int PublisherId) {
        Publisher publisher = (Publisher) em.find(Publisher.class, PublisherId);
//        em.remove(publisher);
        em.getTransaction().begin();
        em.remove(publisher);
        em.getTransaction().commit();
    }

    @Override
    public Publisher getPublisherById(int PublisherId) {
        return (Publisher) em.find(Publisher.class, PublisherId);
    }

    @Override
    public Publisher getPublisherByName(String PublisherName) {
        Collection<Publisher> publishers = em.createNamedQuery("Publisher.findByPublisherName")
                .setParameter("publisherName", PublisherName)
                .getResultList();

        return (Publisher) publishers;
    }

    @Override
    public Collection<Publisher> getAllPublisher() {
        return em.createNamedQuery("Publisher.findAll").getResultList();
    }

    // </editor-fold>
}
