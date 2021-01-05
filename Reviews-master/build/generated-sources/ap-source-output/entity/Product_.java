package entity;

import entity.Advertise;
import entity.Author;
import entity.Category;
import entity.Company;
import entity.Genre;
import entity.Publisher;
import entity.Reviews;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Genre> genreId;
    public static volatile CollectionAttribute<Product, Advertise> advertiseCollection;
    public static volatile SingularAttribute<Product, Company> companyId;
    public static volatile SingularAttribute<Product, Publisher> publisherId;
    public static volatile SingularAttribute<Product, String> productImage;
    public static volatile SingularAttribute<Product, Integer> productId;
    public static volatile SingularAttribute<Product, Author> authorId;
    public static volatile CollectionAttribute<Product, Reviews> reviewsCollection;
    public static volatile SingularAttribute<Product, String> referenceLink;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, Category> categoryId;

}