package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.Entities.Famille;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, String> forme;
    public static volatile SingularAttribute<Produit, Float> dosage;
    public static volatile SingularAttribute<Produit, Double> qteseuil;
    public static volatile SingularAttribute<Produit, Long> idProd;
    public static volatile SingularAttribute<Produit, String> designationProd;
    public static volatile SingularAttribute<Produit, Famille> famille;
    public static volatile SingularAttribute<Produit, Boolean> supprime;

}