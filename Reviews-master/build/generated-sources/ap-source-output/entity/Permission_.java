package entity;

import entity.Rolepermission;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Permission.class)
public class Permission_ { 

    public static volatile SingularAttribute<Permission, Integer> permissionId;
    public static volatile CollectionAttribute<Permission, Rolepermission> rolepermissionCollection;
    public static volatile SingularAttribute<Permission, String> permissionName;

}