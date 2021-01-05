package entity;

import entity.Rolepermission;
import entity.Userrole;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> roleId;
    public static volatile SingularAttribute<Role, String> roleName;
    public static volatile CollectionAttribute<Role, Userrole> userroleCollection;
    public static volatile CollectionAttribute<Role, Rolepermission> rolepermissionCollection;

}