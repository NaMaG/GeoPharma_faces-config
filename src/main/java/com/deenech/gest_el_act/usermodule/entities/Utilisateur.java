/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Mikel
 */
@Entity
@Table(name = "UTILISATEURS")
public class Utilisateur implements Serializable{

    @Id
    @SequenceGenerator(name = "utilisateurSeq", sequenceName = "UTILISATEUR_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "utilisateurSeq")
    @Column(name = "idUser",nullable = false)
    private Long idUser;
    
    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;
    
    @Column(name = "MOT_DE_PASSE",nullable = false)
    private String motDePasse;
    
    @Column(name = "ACTIF", nullable = false)
    private boolean actif;
    
    @Column(name = "NOM", nullable = true)
    private String nom;
    
    @Column(name = "PRENOM", nullable = true)
    private String prenom;
    
    @Column(name = "SEXE", nullable = true)
    private String sexe;
    
    @Column(name = "EMAIL", nullable = true)
    private String adresseEmail;
    
    @Column(name = "REINIT_MOT_DE_PASSE")
    private boolean reinitialiserPswd = false;
    
    @Column(name = "PHOTO", nullable = true)
    private String photo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATION", nullable = true)
    private Date dateCreation;
    
    @Column(name = "CONTACT", nullable = true)
    private String contact;
    
    @Column(name = "ADRESSE", nullable = true)
    private String adresse;
    
    @Column(name = "ROLE", nullable = true)
    private String roles;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Poste_ID", nullable = true)
    private Poste poste;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Profil_ID", nullable = true)
    private Profil profil;

    public Utilisateur() {
    }

    public Utilisateur(Long id, String login, String motDePasse, boolean actif, String nom, String prenom, String sexe, String adresseEmail, String photo, Date dateCreation, String contact, String adresse, String role, Poste poste, Profil profil) {
        this.idUser = id;
        this.login = login;
        this.motDePasse = motDePasse;
        this.actif = actif;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresseEmail = adresseEmail;
        this.photo = photo;
        this.dateCreation = dateCreation;
        this.contact = contact;
        this.adresse = adresse;
        this.roles = role;
        this.poste = poste;
        this.profil = profil;
    }

    
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }   

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }    

    public Long getId() {
        return idUser;
    }

    public void setId(Long id) {
        this.idUser = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomComplet() {
        return nom + " " + prenom;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    public boolean isReinitialiserPswd() {
        return reinitialiserPswd;
    }

    public void setReinitialiserPswd(boolean reinitialiserPswd) {
        this.reinitialiserPswd = reinitialiserPswd;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.idUser);
        hash = 59 * hash + Objects.hashCode(this.login);
        hash = 59 * hash + Objects.hashCode(this.motDePasse);
        hash = 59 * hash + (this.actif ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.prenom);
        hash = 59 * hash + Objects.hashCode(this.sexe);
        hash = 59 * hash + Objects.hashCode(this.adresseEmail);
        hash = 59 * hash + (this.reinitialiserPswd ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.dateCreation);
        hash = 59 * hash + Objects.hashCode(this.contact);
        hash = 59 * hash + Objects.hashCode(this.adresse);
        hash = 59 * hash + Objects.hashCode(this.roles);
        hash = 59 * hash + Objects.hashCode(this.poste);
        hash = 59 * hash + Objects.hashCode(this.profil);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.motDePasse, other.motDePasse)) {
            return false;
        }
        if (this.actif != other.actif) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.adresseEmail, other.adresseEmail)) {
            return false;
        }
        if (this.reinitialiserPswd != other.reinitialiserPswd) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        if (!Objects.equals(this.dateCreation, other.dateCreation)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.poste, other.poste)) {
            return false;
        }
        return Objects.equals(this.profil, other.profil);
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + idUser + ", login=" + login + ", motDePasse=" + motDePasse + ", actif=" + actif + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", adresseEmail=" + adresseEmail + ", reinitialiserPswd=" + reinitialiserPswd + ", photo=" + photo + ", dateCreation=" + dateCreation + ", contact=" + contact + ", adresse=" + adresse + ", role=" + roles + ", poste=" + poste + ", profil=" + profil + '}';
    }

//    public String creerChaineModification(Object o) {
//        Utilisateur ancien = (Utilisateur) o;
//        if (ancien == null) {
//            ancien = new Utilisateur();
//        }
//        String str = "(";
//        if (this.login != null) {
//            if (!this.login.equals(ancien.login)) {
//                str += "login: " + this.login;
//            }
//        }
//        if (this.nom != null) {
//            if (!this.nom.equals(ancien.nom)) {
//                str += ", nom: " + this.nom;
//            }
//        }
//        if (this.prenom != null) {
//            if (!this.prenom.equals(ancien.prenom)) {
//                str += ", prenom: " + this.prenom;
//            }
//        }
//        
//        if (this.sexe != null) {
//            if (!this.sexe.equals(ancien.sexe)) {
//                str += ", sexe: " + this.sexe;
//            }
//        }
//        if (this.motDePasse != null) {
//            if (!this.motDePasse.equals(ancien.motDePasse)) {
//                str += ", mot de passe modifié";
//            }
//        }
//        if (this.actif != ancien.actif) {
//            str += ", actif: " + this.actif;
//        }
//        if (this.adresseEmail != null) {
//            if (!this.adresseEmail.equals(ancien.adresseEmail)) {
//                str += ", email: " + this.adresseEmail;
//            }
//        }
//
//        if (this.reinitialiserPswd != ancien.reinitialiserPswd) {
//            str += ", reinitialiser: " + this.reinitialiserPswd;
//        }
//
//        str += ")";
//        setChaineModification(str);
//        return str;
//    }

    
}

