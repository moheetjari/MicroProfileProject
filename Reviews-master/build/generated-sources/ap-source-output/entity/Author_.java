package entity;

import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile CollectionAttribute<Author, Product> productCollection;
    public static volatile SingularAttribute<Author, String> authorName;
    public static volatile SingularAttribute<Author, Integer> authorId;

}