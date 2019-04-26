package com.deenech.gest_el_act.usermodule.entities;

import com.deenech.gest_el_act.usermodule.entities.Droit;
import com.deenech.gest_el_act.usermodule.entities.PossederId;
import com.deenech.gest_el_act.usermodule.entities.Profil;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(Posseder.class)
public class Posseder_ { 

    public static volatile SingularAttribute<Posseder, Droit> droitUtilisateur;
    public static volatile SingularAttribute<Posseder, Profil> profil;
    public static volatile SingularAttribute<Posseder, PossederId> id;

}