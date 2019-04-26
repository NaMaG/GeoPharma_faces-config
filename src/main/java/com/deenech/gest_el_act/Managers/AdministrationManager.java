/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Managers;

import com.deenech.gest_el_act.Entities.Pharmacie;
import com.deenech.gest_el_act.Filter.constante;
import com.deenech.gest_el_act.Parameters.Mtm;
import com.deenech.gest_el_act.Parameters.TransactionManager;
import com.deenech.gest_el_act.Shiro.EntityRealm;
import com.deenech.gest_el_act.usermodule.Services.DroitService;
import com.deenech.gest_el_act.usermodule.Services.PossederService;
import com.deenech.gest_el_act.usermodule.Services.PosteService;
import com.deenech.gest_el_act.usermodule.Services.ProfilService;
import com.deenech.gest_el_act.usermodule.Services.UtilisateurService;
import com.deenech.gest_el_act.usermodule.entities.Droit;
import com.deenech.gest_el_act.usermodule.entities.Posseder;
import com.deenech.gest_el_act.usermodule.entities.PossederId;
import com.deenech.gest_el_act.usermodule.entities.Poste;
import com.deenech.gest_el_act.usermodule.entities.Profil;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 *
 * @author GOKAR
 */

@ViewScoped


@Named("AdministrationManager")
public class AdministrationManager implements Serializable{
    private final Pharmacie pharmacie;
    private Utilisateur utilisateur;
    
    private Utilisateur utilisateurTampon;
    private Utilisateur utilisateur2;
    private Utilisateur utilisateurProfil;
    private Utilisateur utilisateurPswd;
    private Profil profil;
    private Profil profilTampon;
    private Posseder posseder;
    private PossederId possederId;
    private Poste poste;
    private boolean disAdmin;

    private List<Utilisateur> utilisateurListe;
    private List<Utilisateur> utilisateurListeSansAdmin;
    private List<Droit> droitListe;
    private List<Droit> droitListeSource;
    private List<Droit> droitListeSupp;
    private List<Profil> profilListe;
    private List<Poste> posteListe;
    

   @EJB
   private UtilisateurService utilisateurservice;
   
   @EJB
   private DroitService droitservice;
   
   @EJB
   private ProfilService profilservice;
   
   @EJB
   private PosteService posteservice;
   
   @EJB
   private PossederService possederservice;

    public AdministrationManager(){
        utilisateur = new Utilisateur();
        this.utilisateurTampon = new Utilisateur();
        this.utilisateur2 = new Utilisateur();
        this.utilisateurProfil = new Utilisateur();
        this.utilisateurPswd = new Utilisateur();
        this.profil = new Profil();
        this.profilTampon = new Profil();
        this.posseder = new Posseder();
        this.possederId = new PossederId();
        this.poste = new Poste();
       // this.disAdmin =new Profil();
        this.utilisateurListe =new ArrayList<>();
        this.utilisateurListeSansAdmin = new ArrayList<>();
        this.droitListe = new ArrayList<>();
        this.droitListeSource = new ArrayList<>();
        this.droitListeSupp = new ArrayList<>();
        this.profilListe =new ArrayList<>();
        this.posteListe = new ArrayList<>();
        pharmacie= new Pharmacie();
//        emfactory=Persistence.createEntityManagerFactory("Gest_El_ActPU");
       // entitymanager=emfactory.createEntityManager();
    }
    
    
    public void ajouterUtilisateur() {
        if (EntityRealm.getSubject().isPermitted(constante.ROLE_ALL_CLE)|| EntityRealm.getSubject().isPermitted(constante.ROLE_ADMIN_CLE)) {
            UserTransaction tx = TransactionManager.getUserTransaction();
            try {
                tx.begin();
                
                if (utilisateur.getNom().isEmpty()) {
                    Mtm.mikiMessageWarnSaisir("le nom");
                } else if (utilisateur.getPrenom().isEmpty()) {
                    Mtm.mikiMessageWarnSaisir("le prénom");
                } else if (utilisateur.getContact().isEmpty()) {
                    Mtm.mikiMessageWarnSaisir("le contact");
                } else if (utilisateur.getAdresse().isEmpty()) {
                    Mtm.mikiMessageWarnSaisir("l'adresse");
                } else if (utilisateur.getLogin().isEmpty()) {
                    Mtm.mikiMessageWarnSaisir("le nom d'utilisateur");
                } else {
                    if (utilisateur.getId() == null) {
                        if (utilisateurservice.getBy("login", utilisateur.getLogin()).isEmpty()) {
                            
                            utilisateur.setMotDePasse(new Sha256Hash(constante.MOT_DE_PASSE_DEFAUT).toHex());
//                            utilisateur.setPhoto(tofProfil);
                            utilisateur.setDateCreation(new Date());
                            utilisateur.setProfil(profilservice.getOneBy("nomProf", "Invite"));
                            utilisateur.setReinitialiserPswd(true);
                            utilisateurservice.saveOne(utilisateur);
                            
                            
                            tx.commit();
                            //Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.INFO, "Enregistrement d'un personnel :" + utilisateur.getNom() + " " + utilisateur.getPrenom());
                            utilisateur = new Utilisateur();
//                            tofProfil = "images/tofProfilDefaut.png";
                            Mtm.mikiMessageInfo();
                        } else {
                            Mtm.mikiMessageErrorPerso("Ce nom d'utilisateur est déja utilisé, réessayez svp !");
                        }
                    } else {
                        
                        utilisateurservice.updateOne(utilisateur);
                        tx.commit();

                        if (utilisateur.getNom().equals(utilisateurTampon.getNom()) && utilisateur.getPrenom().equals(utilisateurTampon.getPrenom())) {
                            //Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.INFO, "Modification des données du personnel :" + utilisateur.getNom() + " " + utilisateur.getPrenom());
                        } else {
                            //Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.INFO, "Modification de donnée d'un personnel :" + utilisateurTampon.getNom() + " " + utilisateurTampon.getPrenom() + ", par :"
                                  //  + utilisateur.getNom() + " " + utilisateur.getPrenom());
                        }
                        utilisateur = new Utilisateur();
                        utilisateurTampon = new Utilisateur();
//                        tofProfil = "images/tofProfilDefaut.png";
                        Mtm.mikiMessageInfo();
                    }
                }
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                try {
                    tx.rollback();
                } catch (IllegalStateException | SecurityException | SystemException ex1) {
                    Logger.getLogger(AdministrationManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.toString();
                Mtm.mikiMessageError();
            }
        } else {
            Mtm.mikiMessageWarn("Vous n'avez pas ce droit");
        }

    }
    
    public void annulerUtilisateur() {
        utilisateur = new Utilisateur();
        disAdmin = false;
    }
    
    public void affectationUtilisateurDroit() {
        if (EntityRealm.getSubject().isPermitted(constante.ROLE_ALL_CLE) || EntityRealm.getSubject().isPermitted(constante.ROLE_ADMIN_CLE)) {
            UserTransaction tx = TransactionManager.getUserTransaction();
            try {
                tx.begin();
                if (utilisateurProfil == null) {
                    Mtm.mikiMessageWarnChoisir("l'utilisateur");
                } else if (utilisateurProfil.getProfil() == null) {
                    Mtm.mikiMessageWarnSelectionner("le profil a affecter à l'utilisateur");
                } else {
                  
                    utilisateurservice.updateOne(utilisateurProfil);
                    
                   
                    tx.commit();
                    //Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.INFO, "Affectation du profil : " + utilisateurProfil.getProfil().getNomProf() + ", à l'utilsateur : " + utilisateurProfil.getLogin());
                    utilisateurProfil = new Utilisateur();
                    Mtm.mikiMessageInfo();
                }
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                try {
                    tx.rollback();
                } catch (IllegalStateException | SecurityException | SystemException ex1) {
                    Logger.getLogger(AdministrationManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                Mtm.mikiMessageError();
            }
        } else {
            Mtm.mikiMessageWarn("Vous n'êtes pas autorisé");
        }

    }

        public void ajouterProfil() {
        if (EntityRealm.getSubject().isPermitted(constante.ROLE_ALL_CLE) || EntityRealm.getSubject().isPermitted(constante.ROLE_ADMIN_CLE)) {
            UserTransaction tx = TransactionManager.getUserTransaction();
            try {
                tx.begin();
                if (profil.getNomProf().isEmpty()) {
                    Mtm.mikiMessageWarnSaisir("le nom du profil");
                } else if (droitListeSource.isEmpty()) {
                    Mtm.mikiMessageWarnSelectionner("le(s) droit(s)");
                } else {
                    if (profil.getIdProf() == null) {
                        profil.setDateCreaProf(new Date());
                        profilservice.saveOne(profil);
                        tx.commit();

                        List<Posseder> possederProfil;
                        possederProfil = new ArrayList<>();
                        for (Droit drt : droitListeSource) {
                            tx.begin();
                            possederId.setProfilID(profil.getIdProf());
                            possederId.setDroitUtilID(drt.getCodeDroit());
                            posseder.setId(possederId);
                            posseder.setProfil(profil);
                            posseder.setDroitUtilisateur(drt);

                            this.possederservice.saveOne(posseder);
                            tx.commit();

                            possederProfil.add(posseder);
                            posseder = new Posseder();
                            possederId = new PossederId();
                        }

                        for (Posseder po : possederProfil) {
                            tx.begin();
                            profil.ajouterPosseder(po);
                            profilservice.updateOne(profil);
                            tx.commit();
                        }

                        //Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.INFO, "Ajout d'un profil : " + profil.getNomProf());
                        profil = new Profil();
                        droitListeSource = new ArrayList<>();
                        Mtm.mikiMessageInfo();
                    } else {
                        profilservice.updateOne(profil);
                        tx.commit();
                        for (Droit drt1 : droitListeSupp) {
                            tx.begin();
                            possederId.setProfilID(profil.getIdProf());
                            possederId.setDroitUtilID(drt1.getCodeDroit());
                            possederservice.deleteOne(possederId);
                            tx.commit();

                            possederId = new PossederId();
                        }

                        List<Posseder> possederProfil3;
                        possederProfil3 = new ArrayList<>();
                        for (Posseder poss : profil.getPosseders()) {
                            possederProfil3.add(poss);
                        }

                        for (Posseder poss2 : possederProfil3) {
                            tx.begin();
                            profil.supprimerPosseder(poss2);
                            profilservice.updateOne(profil);
                            tx.commit();
                        }

                        List<Posseder> possederProfil2;
                        possederProfil2 = new ArrayList<>();
                        for (Droit drt3 : droitListeSource) {
                            tx.begin();
                            possederId.setProfilID(profil.getIdProf());
                            possederId.setDroitUtilID(drt3.getCodeDroit());
                            posseder.setId(possederId);
                            posseder.setProfil(profil);
                            posseder.setDroitUtilisateur(drt3);

                            this.possederservice.saveOne(posseder);
                            tx.commit();

                            possederProfil2.add(posseder);
                            posseder = new Posseder();
                            possederId = new PossederId();
                        }

                        for (Posseder po : possederProfil2) {
                            tx.begin();
                            profil.ajouterPosseder(po);
                            profilservice.updateOne(profil);
                            tx.commit();
                        }
                        if (profil.getNomProf().equals(profilTampon.getNomProf())) {
                           // Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.INFO, "Modification des droits du profil :" + profil.getNomProf());
                            Mtm.mikiMessageInfoPerso("Modification des droits du profil :" + profil.getNomProf());
                        } else {
                           // Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.INFO, "Modification de donnée du profil :" + profilTampon.getNomProf() + ", par :" + profil.getNomProf());
                            Mtm.mikiMessageInfoPerso("Modification de donnée du profil :" + profilTampon.getNomProf() + ", par :" + profil.getNomProf());
                        }
                        profil = new Profil();
                        profilTampon = new Profil();
                        droitListeSource = new ArrayList<>();
                        droitListeSupp = new ArrayList<>();
                        Mtm.mikiMessageInfo();
                    }

                }
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) {
                try {
                    tx.rollback();
                } catch (IllegalStateException | SecurityException | SystemException ex1) {
                    Logger.getLogger(AdministrationManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                //Mtm.logMikiLog4j(GestionUtilisateurs.class.getName(), org.apache.log4j.Level.ERROR, "Erreur survenue lors d'une opération sur le profil:" + profil.getNomProf());
                Mtm.mikiMessageError();
            }
        } else {
            Mtm.mikiMessageInfoPerso("Vous n'avez pas ce droit");
        }

    }

    public void renvoieProfil(Profil pl) {
        if (EntityRealm.getSubject().isPermitted(constante.ROLE_ALL_CLE) || EntityRealm.getSubject().isPermitted(constante.ROLE_ADMIN_CLE)) {
            profil = pl;
            profilTampon = pl;
            for (Posseder drt : pl.getPosseders()) {
                droitListeSource.add(drt.getDroitUtilisateur());
            }

            droitListeSupp = droitListeSource;
        } else {
            Mtm.mikiMessageInfoPerso("Pas d'autorisation");
        }
    }
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateurTampon() {
        return utilisateurTampon;
    }

    public void setUtilisateurTampon(Utilisateur utilisateurTampon) {
        this.utilisateurTampon = utilisateurTampon;
    }

    public Utilisateur getUtilisateur2() {
        return utilisateur2;
    }

    public void setUtilisateur2(Utilisateur utilisateur2) {
        this.utilisateur2 = utilisateur2;
    }

    public Utilisateur getUtilisateurProfil() {
        return utilisateurProfil;
    }

    public void setUtilisateurProfil(Utilisateur utilisateurProfil) {
        this.utilisateurProfil = utilisateurProfil;
    }

    public Utilisateur getUtilisateurPswd() {
        return utilisateurPswd;
    }

    public void setUtilisateurPswd(Utilisateur utilisateurPswd) {
        this.utilisateurPswd = utilisateurPswd;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Profil getProfilTampon() {
        return profilTampon;
    }

    public void setProfilTampon(Profil profilTampon) {
        this.profilTampon = profilTampon;
    }

    public Posseder getPosseder() {
        return posseder;
    }

    public void setPosseder(Posseder posseder) {
        this.posseder = posseder;
    }

    public PossederId getPossederId() {
        return possederId;
    }

    public void setPossederId(PossederId possederId) {
        this.possederId = possederId;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public boolean isDisAdmin() {
        return disAdmin;
    }

    public void setDisAdmin(boolean disAdmin) {
        this.disAdmin = disAdmin;
    }

    public List<Utilisateur> getUtilisateurListe() {
        return utilisateurListe;
    }

    public void setUtilisateurListe(List<Utilisateur> utilisateurListe) {
        this.utilisateurListe = utilisateurListe;
    }

    public List<Utilisateur> getUtilisateurListeSansAdmin() {
        return utilisateurListeSansAdmin;
    }

    public void setUtilisateurListeSansAdmin(List<Utilisateur> utilisateurListeSansAdmin) {
        this.utilisateurListeSansAdmin = utilisateurListeSansAdmin;
    }

    public List<Droit> getDroitListe() {
        return droitListe;
    }

    public void setDroitListe(List<Droit> droitListe) {
        this.droitListe = droitListe;
    }

    public List<Droit> getDroitListeSource() {
        return droitListeSource;
    }

    public void setDroitListeSource(List<Droit> droitListeSource) {
        this.droitListeSource = droitListeSource;
    }

    public List<Droit> getDroitListeSupp() {
        return droitListeSupp;
    }

    public void setDroitListeSupp(List<Droit> droitListeSupp) {
        this.droitListeSupp = droitListeSupp;
    }

    public List<Profil> getProfilListe() {
        return profilListe;
    }

    public void setProfilListe(List<Profil> profilListe) {
        this.profilListe = profilListe;
    }

    public List<Poste> getPosteListe() {
        return posteListe;
    }

    public void setPosteListe(List<Poste> posteListe) {
        this.posteListe = posteListe;
    }

    public UtilisateurService getUtilisateurservice() {
        return utilisateurservice;
    }

    public void setUtilisateurservice(UtilisateurService utilisateurservice) {
        this.utilisateurservice = utilisateurservice;
    }

    public DroitService getDroitservice() {
        return droitservice;
    }

    public void setDroitservice(DroitService droitservice) {
        this.droitservice = droitservice;
    }

    public ProfilService getProfilservice() {
        return profilservice;
    }

    public void setProfilservice(ProfilService profilservice) {
        this.profilservice = profilservice;
    }

    public PosteService getPosteservice() {
        return posteservice;
    }

    public void setPosteservice(PosteService posteservice) {
        this.posteservice = posteservice;
    }

    public PossederService getPossederservice() {
        return possederservice;
    }

    public void setPossederservice(PossederService possederservice) {
        this.possederservice = possederservice;
    }
   
   /*  public void ajouterActivite() {
        if (EntityRealm.getSubject().isPermitted(constante.ROLE_ALL_CLE)|| EntityRealm.getSubject().isPermitted(constante.ROLE_ADMIN_CLE)) {
            UserTransaction tx = TransactionManager.getUserTransaction();
            try {
                tx.begin();
                
                if (activite.getLibelle().isEmpty()) {
                    Mtm.mikiMessageWarnSaisir("la designation");
               } else {}
             
            } 
            catch (NotSupportedException | SystemException | SecurityException | IllegalStateException ex) {
            try {
                    tx.rollback();
                } catch (IllegalStateException | SecurityException | SystemException ex1) {
                    Logger.getLogger(AdministrationManager.class.getName()).log(Level.SEVERE, null, ex1);
                }
                ex.toString();
                Mtm.mikiMessageError();
            }
        } else {
            Mtm.mikiMessageWarn("Vous n'avez pas ce droit");
        }

    }
   public void ModifActivite(String libelle) {
        if (EntityRealm.getSubject().isPermitted(constante.ROLE_ALL_CLE) || EntityRealm.getSubject().isPermitted(constante.ROLE_ADMIN_CLE)) {
            String libelle1=libelle;
            String libelle2 = libelle;
            for (Posseder drt : libelle.getlibelle()) {
                droitListeSource.add(drt.getDroitUtilisateur());
            }

            droitListeSupp = droitListeSource;
        } else {
            Mtm.mikiMessageInfoPerso("Pas d'autorisation");
        }
    } 
       private EntityManagerFactory emfactory;
    private EntityManager entitymanager;
    
 public AdministrationManager(){   
 
 }
  /////////////////////////////////////////////////////////////////////////
        public void modifierActivite (Activite activite) {
   entitymanager.getTransaction().begin();
   Activite ActiviteToUpdate= new Activite(); 
    ActiviteToUpdate=entitymanager.find(Activite.class, activite.getIdAct());
    ActiviteToUpdate.setLibelle(activite.getLibelle());
       entitymanager.getTransaction().commit();
    } 
    //////////////////////////////////////////////////////////////////////////////
         public void supprimerActivite (Long idAct) {
       entitymanager.getTransaction().begin();
     Activite activite=entitymanager.find(Activite.class, idAct);
             entitymanager.remove(activite);
       entitymanager.getTransaction().commit();
             
    } */
    
}
