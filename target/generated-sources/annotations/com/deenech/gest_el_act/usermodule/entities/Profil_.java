package com.deenech.gest_el_act.usermodule.entities;

import com.deenech.gest_el_act.usermodule.entities.Posseder;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(Profil.class)
public class Profil_ { 

    public static volatile SingularAttribute<Profil, Long> idProf;
    public static volatile SetAttribute<Profil, Posseder> posseders;
    public static volatile SingularAttribute<Profil, String> nomProf;
    public static volatile SetAttribute<Profil, Utilisateur> compteUtilisateurs;
    public static volatile SingularAttribute<Profil, String> description;
    public static volatile SingularAttribute<Profil, Date> dateCreaProf;

}