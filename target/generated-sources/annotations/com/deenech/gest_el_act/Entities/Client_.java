package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T14:45:55")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, String> profession;
    public static volatile SingularAttribute<Client, Date> dateEnreg;
    public static volatile SingularAttribute<Client, Long> idClt;
    public static volatile SingularAttribute<Client, String> contact;
    public static volatile SingularAttribute<Client, String> adresse;
    public static volatile SingularAttribute<Client, Date> dateNaiss;
    public static volatile SingularAttribute<Client, String> nomClt;
    public static volatile SingularAttribute<Client, String> prenomClt;
    public static volatile SingularAttribute<Client, Utilisateur> user;
    public static volatile SingularAttribute<Client, Boolean> supprime;

}