package com.deenech.gest_el_act.usermodule.entities;

import com.deenech.gest_el_act.usermodule.entities.Poste;
import com.deenech.gest_el_act.usermodule.entities.Profil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Date> dateCreation;
    public static volatile SingularAttribute<Utilisateur, Profil> profil;
    public static volatile SingularAttribute<Utilisateur, String> roles;
    public static volatile SingularAttribute<Utilisateur, String> photo;
    public static volatile SingularAttribute<Utilisateur, Boolean> actif;
    public static volatile SingularAttribute<Utilisateur, String> sexe;
    public static volatile SingularAttribute<Utilisateur, String> adresseEmail;
    public static volatile SingularAttribute<Utilisateur, String> login;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, Long> idUser;
    public static volatile SingularAttribute<Utilisateur, String> motDePasse;
    public static volatile SingularAttribute<Utilisateur, String> contact;
    public static volatile SingularAttribute<Utilisateur, String> adresse;
    public static volatile SingularAttribute<Utilisateur, Poste> poste;
    public static volatile SingularAttribute<Utilisateur, String> prenom;
    public static volatile SingularAttribute<Utilisateur, Boolean> reinitialiserPswd;

}