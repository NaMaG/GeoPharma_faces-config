/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Managers;

import com.deenech.gest_el_act.Filter.constante;
import com.deenech.gest_el_act.Parameters.Mtm;
import com.deenech.gest_el_act.usermodule.Services.DroitService;
import com.deenech.gest_el_act.usermodule.Services.PossederService;
import com.deenech.gest_el_act.usermodule.Services.ProfilService;
import com.deenech.gest_el_act.usermodule.Services.UtilisateurService;
import com.deenech.gest_el_act.usermodule.entities.Droit;
import com.deenech.gest_el_act.usermodule.entities.Posseder;
import com.deenech.gest_el_act.usermodule.entities.PossederId;
import com.deenech.gest_el_act.usermodule.entities.Poste;
import com.deenech.gest_el_act.usermodule.entities.Profil;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.omnifaces.util.Faces;
import org.primefaces.context.RequestContext;

/**
 *
 * @author sare
 */
@ManagedBean(name = "ConnectionManager")
@SessionScoped
public class ConnectionManager implements Serializable {

    private Utilisateur userConnexion, userConnexionTest, user;
    private Profil profilUtilisateur, profAdmin, profil2;
    private Posseder posseder;
    private PossederId possederId;
    private Droit droitTous;
    private List<Droit> droitUtilisateurs2;
    private List<Poste> postes;
    private List<Profil> profilList;
    private List<Utilisateur> users;
    private String user1;
    private String newMdp;
    private String comfMdp;

    @EJB
    private UtilisateurService userService;

    @EJB
    private ProfilService profService;

    @EJB
    private PossederService possederService;

    @EJB
    private DroitService droitService;

    public ConnectionManager() {

        userConnexion = new Utilisateur();
        userConnexionTest = new Utilisateur();
        user = new Utilisateur();
        droitTous = new Droit();
        profilUtilisateur = new Profil();
        profAdmin = new Profil();
        profil2 = new Profil();
        posseder = new Posseder();
        possederId = new PossederId();
        droitUtilisateurs2 = new ArrayList<>();
        postes = new ArrayList<>();
        profilList = new ArrayList<>();
        users = new ArrayList<>();
        user1 = new String();
        newMdp = new String();
        comfMdp = new String();
    }

    @PostConstruct
    public void init() {

        List<Droit> droitUsers = droitService.getAll();

        if (droitUsers.isEmpty()) {
            droitService.saveOne(new Droit(constante.ROLE_ALL, constante.ROLE_ALL_CLE));
            droitService.saveOne(new Droit(constante.ROLE_ADMIN, constante.ROLE_ADMIN_CLE));
        }

        profilList = profService.getAll();
        if (profilList.isEmpty()) {
            profilUtilisateur.setNomProf("Admin");
            profilUtilisateur.setDateCreaProf(new Date());
            profService.saveOne(profilUtilisateur);

            droitUtilisateurs2 = droitService.getNonBy("libDroit", "Tous");

            for (Droit drt : droitUtilisateurs2) {
                possederId.setProfilID(profilUtilisateur.getIdProf());
                possederId.setDroitUtilID(drt.getCodeDroit());
                posseder.setId(possederId);
                posseder.setProfil(profilUtilisateur);
                posseder.setDroitUtilisateur(drt);

                this.possederService.saveOne(posseder);

                posseder = new Posseder();
                possederId = new PossederId();
            }

            profService.saveOne(new Profil("Invite", "Pour les utilisateurs qui n'ont pas de droit", new Date()));

            List<Posseder> poss = possederService.getBy("profil", profilUtilisateur);
            for (Posseder po : poss) {
                profilUtilisateur.ajouterPosseder(po);
                profService.updateOne(profilUtilisateur);
            }

            profil2.setNomProf("All_privilege");
            profil2.setDateCreaProf(new Date());
            profService.saveOne(profil2);

            droitTous = droitService.getOneBy("libDroit", "Tous");

            possederId.setProfilID(profil2.getIdProf());
            possederId.setDroitUtilID(droitTous.getCodeDroit());
            posseder.setId(possederId);
            posseder.setProfil(profil2);
            posseder.setDroitUtilisateur(droitTous);

            this.possederService.saveOne(posseder);

            posseder = new Posseder();
            possederId = new PossederId();

            List<Posseder> poss2 = possederService.getBy("profil", profil2);
            for (Posseder po2 : poss2) {
                profil2.ajouterPosseder(po2);
                profService.updateOne(profil2);
            }
        }

        users = userService.getAll();
        if (users.isEmpty()) {
            user.setNom("Admin");
            user.setPrenom("Admin");
            user.setSexe("-");
            user.setLogin("admin");
            //user.setPoste(poste);
            user.setMotDePasse(new Sha256Hash(constante.MOT_DE_PASSE_DEFAUT).toHex());
            user.setDateCreation(new Date());
            user.setReinitialiserPswd(true);
            user.setActif(true);
            //user.setPhoto(tofProfil);
            user.setProfil(profil2);

            this.userService.saveOne(user);

        }

        user = new Utilisateur();
        //poste = new Poste();
        profilUtilisateur = new Profil();
        profil2 = new Profil();
        droitTous = new Droit();
        droitUtilisateurs2 = new ArrayList<>();

    }

    public void connexionUser() throws IOException {
        UsernamePasswordToken token = new UsernamePasswordToken(userConnexion.getLogin().trim(), userConnexion.getMotDePasse().trim());
        token.setRememberMe(true);

        try {
            SecurityUtils.getSubject().login(token);

            userConnexionTest = userService.getOneBy("login", userConnexion.getLogin());

            if (userConnexionTest.isReinitialiserPswd()) {
                //Reinitialisation du mot de passe
                RequestContext context = RequestContext.getCurrentInstance();
                System.out.println("le modal de changement de mot de passe...");
                context.execute("jQuery('#EnregMdp').modal('show', {backdrop: 'static'});");
            } else {
                user1 = userConnexionTest.getLogin();
                //userProfil = userConnexionTest.getPhoto();

                SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
                Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : "Accueil.xhtml");
//           // Mtm.logMikiLog4j(ConnexionManagedBean.class.getName(), Level.INFO, "Connexion à l'application");
            }

        } catch (UnknownAccountException uae) {
            //L'utilisateur n'est pas dans le système
            Mtm.mikiMessageErrorPerso(uae.getMessage());
        } catch (IncorrectCredentialsException ice) {
            Mtm.mikiMessageErrorPerso("Mot de passe incorrect, veuillez réessayer Svp !");
        } catch (LockedAccountException lae) {
            //Compte inactif
            Mtm.mikiMessageWarn(lae.getMessage());
            userConnexion = new Utilisateur();
        } catch (AuthenticationException e) {
            //e.printStackTrace();
            Mtm.mikiMessageError();
            userConnexion = new Utilisateur();
        }

    }

    
    public String validate(String username, String pass) {
        String flag = "failure";
        try {
            Properties prop = new Properties();
            InputStream in = getClass().getResourceAsStream("/dbConnection.properties");
            try {
                prop.load(in);
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String driverName = prop.getProperty("jdbc.driverClassName");
            Class.forName(driverName).newInstance();
            String nameForConnect = username;
            String passw = pass;
            String url = prop.getProperty("jdbc.url");
            Connection conn = DriverManager.getConnection(url, nameForConnect, passw);
            if (conn != null) {
                flag = "succes";
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            return "echec";
        }
        return flag;/**/
    }

    
    public void modifMdp() throws IOException {

        userConnexionTest = userService.getOneBy("login", userConnexion.getLogin());

        if (newMdp.trim().equals(comfMdp.trim())) {
            userConnexionTest.setMotDePasse(new Sha256Hash(newMdp).toHex());
            userConnexionTest.setReinitialiserPswd(false);

            this.userService.updateOne(userConnexionTest);
            user1 = userConnexionTest.getLogin();

            try {
                SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
                Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : "Accueil.xhtml");
                Mtm.mikiMessageInfoPerso("Connection à l'application...");
            } catch (AuthenticationException e) {
                Mtm.mikiMessageError();
            }

        } else {
            FacesMessage message5 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Les mots de passe ne sont pas identiques, veuillez resaisir Svp ! ", "");
            FacesContext.getCurrentInstance().addMessage(null, message5);
        }

    }

    public Utilisateur getUserConnexion() {
        return userConnexion;
    }

    public void setUserConnexion(Utilisateur userConnexion) {
        this.userConnexion = userConnexion;
    }

    public Utilisateur getUserConnexionTest() {
        return userConnexionTest;
    }

    public void setUserConnexionTest(Utilisateur userConnexionTest) {
        this.userConnexionTest = userConnexionTest;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Profil getProfilUtilisateur() {
        return profilUtilisateur;
    }

    public void setProfilUtilisateur(Profil profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
    }

    public Profil getProfAdmin() {
        return profAdmin;
    }

    public void setProfAdmin(Profil profAdmin) {
        this.profAdmin = profAdmin;
    }

    public Profil getProfil2() {
        return profil2;
    }

    public void setProfil2(Profil profil2) {
        this.profil2 = profil2;
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

    public List<Droit> getDroitUtilisateurs2() {
        return droitUtilisateurs2;
    }

    public void setDroitUtilisateurs2(List<Droit> droitUtilisateurs2) {
        this.droitUtilisateurs2 = droitUtilisateurs2;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }

    public List<Profil> getProfilList() {
        return profilList;
    }

    public void setProfilList(List<Profil> profilList) {
        this.profilList = profilList;
    }

    public List<Utilisateur> getUsers() {
        return users;
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }

    public UtilisateurService getUserService() {
        return userService;
    }

    public void setUserService(UtilisateurService userService) {
        this.userService = userService;
    }

    public ProfilService getProfService() {
        return profService;
    }

    public void setProfService(ProfilService profService) {
        this.profService = profService;
    }

    public PossederService getPossederService() {
        return possederService;
    }

    public void setPossederService(PossederService possederService) {
        this.possederService = possederService;
    }

    public DroitService getDroitService() {
        return droitService;
    }

    public void setDroitService(DroitService droitService) {
        this.droitService = droitService;
    }

    public Droit getDroitTous() {
        return droitTous;
    }

    public void setDroitTous(Droit droitTous) {
        this.droitTous = droitTous;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getNewMdp() {
        return newMdp;
    }

    public void setNewMdp(String newMdp) {
        this.newMdp = newMdp;
    }

    public String getComfMdp() {
        return comfMdp;
    }

    public void setComfMdp(String comfMdp) {
        this.comfMdp = comfMdp;
    }

}
