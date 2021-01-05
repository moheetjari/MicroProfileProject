package entity;

import entity.Permission;
import entity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Rolepermission.class)
public class Rolepermission_ { 

    public static volatile SingularAttribute<Rolepermission, Integer> rolePermissionId;
    public static volatile SingularAttribute<Rolepermission, Permission> permissionId;
    public static volatile SingularAttribute<Rolepermission, Role> roleId;

}