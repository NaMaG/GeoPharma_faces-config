package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.Entities.Produit;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(Exemplaire.class)
public class Exemplaire_ { 

    public static volatile SingularAttribute<Exemplaire, Long> idExemplaire;
    public static volatile SingularAttribute<Exemplaire, Produit> prod;
    public static volatile SingularAttribute<Exemplaire, Double> prix;
    public static volatile SingularAttribute<Exemplaire, Date> dateFabrication;
    public static volatile SingularAttribute<Exemplaire, Date> datePeremption;
    public static volatile SingularAttribute<Exemplaire, String> nbreExemplaire;
    public static volatile SingularAttribute<Exemplaire, Boolean> supprime;

}