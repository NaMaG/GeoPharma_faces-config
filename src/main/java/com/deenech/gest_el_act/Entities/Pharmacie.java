
package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author GOKAR
 */
@Entity
@Table(name = "PHARMACIE") 
public class Pharmacie implements Serializable {

    @Id
    @Column(name = "idPharma", nullable = false)
    @SequenceGenerator(name = "PharmaSeq", sequenceName = "Pharma_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PharmaSeq")
    private Long idPharma;

    @Column(name = "nomPharma", nullable = false)
    private String nomPharma;

    @Column(name = "adresse", nullable = false)
    private String adresse;
	
    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "ville", nullable = false)
    private String ville;

    @Column(name = "dateEnreg", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEnreg;

    @Column(name = "garde", nullable = false)
    private Boolean garde;
    
    @Column(name = "horaire", nullable = false)
    private String horaire;
    
	@Column(name = "supprime", nullable = false)
    private Boolean supprime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", nullable = false)
    private Utilisateur user;
    
    public Pharmacie(){
    }

    public Pharmacie(Long idPharma, String nomPharma, String adresse, String contact, String ville, Date dateEnreg, Boolean garde, String horaire, Boolean supprime, Utilisateur user) {
        this.idPharma = idPharma;
        this.nomPharma = nomPharma;
        this.adresse = adresse;
        this.contact = contact;
        this.ville = ville;
        this.dateEnreg = dateEnreg;
        this.garde = garde;
        this.horaire = horaire;
        this.supprime = supprime;
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.idPharma);
        hash = 31 * hash + Objects.hashCode(this.nomPharma);
        hash = 31 * hash + Objects.hashCode(this.adresse);
        hash = 31 * hash + Objects.hashCode(this.contact);
        hash = 31 * hash + Objects.hashCode(this.ville);
        hash = 31 * hash + Objects.hashCode(this.dateEnreg);
        hash = 31 * hash + Objects.hashCode(this.garde);
        hash = 31 * hash + Objects.hashCode(this.horaire);
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
        final Pharmacie other = (Pharmacie) obj;
        if (!Objects.equals(this.idPharma, other.idPharma)) {
            return false;
        }
        if (!Objects.equals(this.nomPharma, other.nomPharma)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.dateEnreg, other.dateEnreg)) {
            return false;
        }
        if (!Objects.equals(this.garde, other.garde)) {
            return false;
        }
        if (!Objects.equals(this.horaire, other.horaire)) {
            return false;
        }
        return true;
    }

  
    public void setIdPharma(Long idPharma) {
        this.idPharma = idPharma;
    }

    public void setNomPharma(String nomPharma) {
        this.nomPharma = nomPharma;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setDateEnreg(Date dateEnreg) {
        this.dateEnreg = dateEnreg;
    }

    public void setGarde(Boolean garde) {
        this.garde = garde;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }
    

    public Long getIdPharma() {
        return idPharma;
    }

    public String getNomPharma() {
        return nomPharma;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getContact() {
        return contact;
    }

    public String getVille() {
        return ville;
    }

    public Date getDateEnreg() {
        return dateEnreg;
    }

    public Boolean getGarde() {
        return garde;
    }

    public String getHoraire() {
        return horaire;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public Utilisateur getUser() {
        return user;
    }
    private static final Logger LOG = Logger.getLogger(Pharmacie.class.getName());

    @Override
    public String toString() {
        return "Pharmacie{" + "idPharma=" + idPharma + ", nomPharma=" + nomPharma + ", adresse=" + adresse + ", contact=" + contact + ", ville=" + ville + ", dateEnreg=" + dateEnreg + ", garde=" + garde + ", horaire=" + horaire + ", supprime=" + supprime + ", user=" + user + '}';
    }
     
   
    }
    
