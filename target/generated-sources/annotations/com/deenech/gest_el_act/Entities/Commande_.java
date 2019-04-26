package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.Entities.CommandeID;
import com.deenech.gest_el_act.Entities.Exemplaire;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(Commande.class)
public class Commande_ { 

    public static volatile SingularAttribute<Commande, Exemplaire> exempl;
    public static volatile SingularAttribute<Commande, String> nomCommande;
    public static volatile SingularAttribute<Commande, String> numCommande;
    public static volatile SingularAttribute<Commande, Date> dateCommande;
    public static volatile SingularAttribute<Commande, Utilisateur> user;
    public static volatile SingularAttribute<Commande, CommandeID> idCommande;

}