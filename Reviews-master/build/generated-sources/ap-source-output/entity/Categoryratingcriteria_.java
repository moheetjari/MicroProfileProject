package entity;

import entity.Category;
import entity.Ratingcriterias;
import entity.Reviewxcriteria;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2020-12-09T17:10:38")
@StaticMetamodel(Categoryratingcriteria.class)
public class Categoryratingcriteria_ { 

    public static volatile CollectionAttribute<Categoryratingcriteria, Reviewxcriteria> reviewxcriteriaCollection;
    public static volatile SingularAttribute<Categoryratingcriteria, Ratingcriterias> ratingCriteriaId;
    public static volatile SingularAttribute<Categoryratingcriteria, Integer> categoryRatingCriteriaId;
    public static volatile SingularAttribute<Categoryratingcriteria, Category> categoryId;

}