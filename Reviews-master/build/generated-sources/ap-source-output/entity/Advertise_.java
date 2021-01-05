package entity;

import entity.Product;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Advertise.class)
public class Advertise_ { 

    public static volatile SingularAttribute<Advertise, Product> productId;
    public static volatile SingularAttribute<Advertise, Date> endDate;
    public static volatile SingularAttribute<Advertise, Integer> advertiseId;
    public static volatile SingularAttribute<Advertise, Date> startDate;

}