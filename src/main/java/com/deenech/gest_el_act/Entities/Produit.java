
package com.deenech.gest_el_act.Entities;


import java.io.Serializable;
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


/**
 *
 * @author GOKAR
 */
@Entity
@Table(name = "PRODUIT") 
public class Produit implements Serializable {

    @Id
    @Column(name = "idProd", nullable = false)
    @SequenceGenerator(name = "ProdSeq", sequenceName = "Prod_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ProdSeq")
    private Long idProd;

    @Column(name = "designationProd", nullable = false)
    private String designationProd;

    @Column(name = "dosage", nullable = false)
    private Float dosage;
   
    @Column(name = "qteseuil", nullable = false)
    private double qteseuil;
    
    @Column(name = "forme", nullable = false)
    private String forme;

	
	@Column(name = "supprime", nullable = false)
    private Boolean supprime;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFamille", nullable = false)
    private Famille famille;
    
    public Produit(){
    }

    public Produit(Long idProd, String designationProd, Float dosage, double qteseuil, String forme, Boolean supprime, Famille famille) {
        this.idProd = idProd;
        this.designationProd = designationProd;
        this.dosage = dosage;
        this.qteseuil = qteseuil;
        this.forme = forme;
        this.supprime = supprime;
        this.famille = famille;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.idProd);
        hash = 17 * hash + Objects.hashCode(this.designationProd);
        hash = 17 * hash + Objects.hashCode(this.dosage);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.qteseuil) ^ (Double.doubleToLongBits(this.qteseuil) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.forme);
        hash = 17 * hash + Objects.hashCode(this.famille);
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
        final Produit other = (Produit) obj;
        if (!Objects.equals(this.idProd, other.idProd)) {
            return false;
        }
        if (!Objects.equals(this.designationProd, other.designationProd)) {
            return false;
        }
        if (!Objects.equals(this.dosage, other.dosage)) {
            return false;
        }
        if (Double.doubleToLongBits(this.qteseuil) != Double.doubleToLongBits(other.qteseuil)) {
            return false;
        }
        if (!Objects.equals(this.forme, other.forme)) {
            return false;
        }
        if (!Objects.equals(this.famille, other.famille)) {
            return false;
        }
        return true;
    }
    private static final Logger LOG = Logger.getLogger(Produit.class.getName());

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public String getDesignationProd() {
        return designationProd;
    }

    public void setDesignationProd(String designationProd) {
        this.designationProd = designationProd;
    }

    public Float getDosage() {
        return dosage;
    }

    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    public double getQteseuil() {
        return qteseuil;
    }

    public void setQteseuil(double qteseuil) {
        this.qteseuil = qteseuil;
    }

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProd=" + idProd + ", designationProd=" + designationProd + ", dosage=" + dosage + ", qteseuil=" + qteseuil + ", forme=" + forme + ", supprime=" + supprime + ", famille=" + famille + '}';
    }
    
   
    }
    
