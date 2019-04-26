/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author NaMaG
 */
@Entity
@Table(name = "Commande")
public class Commande implements Serializable{
    @EmbeddedId 
    private CommandeID idCommande;
    @Column(name = "numCommande", nullable = false)
    
    
    private String numCommande;
    
    @Column(name = "nomCommande", nullable = false)
    private String nomCommande;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dateCommande", nullable = false)
    private Date dateCommande;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idExemplaire", nullable = false, insertable = false, updatable = false)
    private Exemplaire exempl;

    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idUser", nullable = false, insertable = false, updatable = false)
    private Utilisateur user;
  
    public Commande(){}

    public Commande(CommandeID idCommande, String numCommande, String nomCommande, Date dateCommande, Exemplaire exempl, Utilisateur user) {
        this.idCommande = idCommande;
        this.numCommande = numCommande;
        this.nomCommande = nomCommande;
        this.dateCommande = dateCommande;
        this.exempl = exempl;
        this.user = user;
    }

    public CommandeID getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(CommandeID idCommande) {
        this.idCommande = idCommande;
    }

    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
        this.numCommande = numCommande;
    }

    public String getNomCommande() {
        return nomCommande;
    }

    public void setNomCommande(String nomCommande) {
        this.nomCommande = nomCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Exemplaire getExempl() {
        return exempl;
    }

    public void setExempl(Exemplaire exempl) {
        this.exempl = exempl;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idCommande);
        hash = 41 * hash + Objects.hashCode(this.numCommande);
        hash = 41 * hash + Objects.hashCode(this.nomCommande);
        hash = 41 * hash + Objects.hashCode(this.dateCommande);
        hash = 41 * hash + Objects.hashCode(this.exempl);
        hash = 41 * hash + Objects.hashCode(this.user);
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
        final Commande other = (Commande) obj;
        if (!Objects.equals(this.idCommande, other.idCommande)) {
            return false;
        }
        if (!Objects.equals(this.numCommande, other.numCommande)) {
            return false;
        }
        if (!Objects.equals(this.nomCommande, other.nomCommande)) {
            return false;
        }
        if (!Objects.equals(this.dateCommande, other.dateCommande)) {
            return false;
        }
        if (!Objects.equals(this.exempl, other.exempl)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }
    private static final Logger LOG = Logger.getLogger(Commande.class.getName());

    @Override
    public String toString() {
        return "Commande{" + "idCommande=" + idCommande + ", numCommande=" + numCommande + ", nomCommande=" + nomCommande + ", dateCommande=" + dateCommande + ", exempl=" + exempl + ", user=" + user + '}';
    }
     
}
