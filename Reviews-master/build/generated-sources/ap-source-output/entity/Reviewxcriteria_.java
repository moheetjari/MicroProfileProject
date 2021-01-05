package entity;

import entity.Categoryratingcriteria;
import entity.Reviews;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Reviewxcriteria.class)
public class Reviewxcriteria_ { 

    public static volatile SingularAttribute<Reviewxcriteria, Integer> rate;
    public static volatile SingularAttribute<Reviewxcriteria, String> description;
    public static volatile SingularAttribute<Reviewxcriteria, Integer> reviewXCriteriaId;
    public static volatile SingularAttribute<Reviewxcriteria, Reviews> reviewId;
    public static volatile SingularAttribute<Reviewxcriteria, Categoryratingcriteria> categoryRatingCriteriaId;

}