package entity;

import entity.Product;
import entity.Reviewxcriteria;
import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Reviews.class)
public class Reviews_ { 

    public static volatile SingularAttribute<Reviews, Date> date;
    public static volatile CollectionAttribute<Reviews, Reviewxcriteria> reviewxcriteriaCollection;
    public static volatile SingularAttribute<Reviews, Product> productId;
    public static volatile SingularAttribute<Reviews, Integer> reviewId;
    public static volatile SingularAttribute<Reviews, Users> userId;

}