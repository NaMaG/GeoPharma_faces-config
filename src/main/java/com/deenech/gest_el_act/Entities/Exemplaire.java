
package com.deenech.gest_el_act.Entities;


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
@Table(name = "Exemplaire") 
public class Exemplaire implements Serializable {

    @Id
    @Column(name = "idExemplaire", nullable = false)
    @SequenceGenerator(name = "ExemplaireSeq", sequenceName = "Exemplaire_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ExemplaireSeq")
    private Long idExemplaire;

    @Column(name = "nbreExemplaire", nullable = false)
    private String nbreExemplaire;

    @Column(name = "prix", nullable = false)
    private double prix;
	
	@Column(name = "dateFabrication", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFabrication;
	
	@Column(name = "datePeremption", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePeremption;
   
	@Column(name = "supprime", nullable = false)
    private Boolean supprime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProd", nullable = false)
    private Produit prod;
    
    public Exemplaire(){
    }

    public Exemplaire(Long idExemplaire, String nbreExemplaire, double prix, Date dateFabrication, Date datePeremption, Boolean supprime, Produit prod) {
        this.idExemplaire = idExemplaire;
        this.nbreExemplaire = nbreExemplaire;
        this.prix = prix;
        this.dateFabrication = dateFabrication;
        this.datePeremption = datePeremption;
        this.supprime = supprime;
        this.prod = prod;
    }

    public Long getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(Long idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public String getNbreExemplaire() {
        return nbreExemplaire;
    }

    public void setNbreExemplaire(String nbreExemplaire) {
        this.nbreExemplaire = nbreExemplaire;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public Produit getProd() {
        return prod;
    }

    public void setProd(Produit prod) {
        this.prod = prod;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idExemplaire);
        hash = 53 * hash + Objects.hashCode(this.nbreExemplaire);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.prix) ^ (Double.doubleToLongBits(this.prix) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.dateFabrication);
        hash = 53 * hash + Objects.hashCode(this.datePeremption);
        hash = 53 * hash + Objects.hashCode(this.prod);
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
        final Exemplaire other = (Exemplaire) obj;
        if (!Objects.equals(this.idExemplaire, other.idExemplaire)) {
            return false;
        }
        if (!Objects.equals(this.nbreExemplaire, other.nbreExemplaire)) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.dateFabrication, other.dateFabrication)) {
            return false;
        }
        if (!Objects.equals(this.datePeremption, other.datePeremption)) {
            return false;
        }
        if (!Objects.equals(this.prod, other.prod)) {
            return false;
        }
        return true;
    }
    private static final Logger LOG = Logger.getLogger(Exemplaire.class.getName());

    @Override
    public String toString() {
        return "Exemplaire{" + "idExemplaire=" + idExemplaire + ", nbreExemplaire=" + nbreExemplaire + ", prix=" + prix + ", dateFabrication=" + dateFabrication + ", datePeremption=" + datePeremption + ", supprime=" + supprime + ", prod=" + prod + '}';
    }
    
   
    }
    
