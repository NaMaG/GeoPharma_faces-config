package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(Pharmacie.class)
public class Pharmacie_ { 

    public static volatile SingularAttribute<Pharmacie, Boolean> garde;
    public static volatile SingularAttribute<Pharmacie, String> horaire;
    public static volatile SingularAttribute<Pharmacie, String> ville;
    public static volatile SingularAttribute<Pharmacie, Date> dateEnreg;
    public static volatile SingularAttribute<Pharmacie, String> nomPharma;
    public static volatile SingularAttribute<Pharmacie, String> contact;
    public static volatile SingularAttribute<Pharmacie, String> adresse;
    public static volatile SingularAttribute<Pharmacie, Long> idPharma;
    public static volatile SingularAttribute<Pharmacie, Utilisateur> user;
    public static volatile SingularAttribute<Pharmacie, Boolean> supprime;

}