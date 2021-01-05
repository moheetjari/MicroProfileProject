package entity;

import entity.Role;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Userrole.class)
public class Userrole_ { 

    public static volatile SingularAttribute<Userrole, Role> roleId;
    public static volatile SingularAttribute<Userrole, Integer> userRoleId;
    public static volatile SingularAttribute<Userrole, Users> userId;

}