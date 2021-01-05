package entity;

import entity.Reviews;
import entity.Userrole;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> phoneNumber;
    public static volatile SingularAttribute<Users, Date> birthdate;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile SingularAttribute<Users, String> interest;
    public static volatile SingularAttribute<Users, String> city;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile CollectionAttribute<Users, Userrole> userroleCollection;
    public static volatile CollectionAttribute<Users, Reviews> reviewsCollection;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, String> email;

}