
package com.deenech.gest_el_act.Entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author GOKAR
 */
@Entity
@Table(name = "FAMILLE")
public class Famille implements Serializable {
    
    @Id
    @Column(name="idFamille", nullable = false)
    @SequenceGenerator(name = "FamilleSeq", sequenceName = "Famille_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "FamilleSeq")
    private Long idFamille;

    @Column(name="libelleFamille", nullable = false)
    private String libelleFamille;
    
    @Column(name = "supprime", nullable = false)
    private Boolean supprime;

    public Famille() {
    }

    public Famille(Long idFamille, String libelleFamille, Boolean supprime) {
        this.idFamille = idFamille;
        this.libelleFamille = libelleFamille;
        this.supprime = supprime;
    }

    public Long getIdFamille() {
        return idFamille;
    }

    public void setIdFamille(Long idFamille) {
        this.idFamille = idFamille;
    }

    public String getLibelleFamille() {
        return libelleFamille;
    }

    public void setLibelleFamille(String libelleFamille) {
        this.libelleFamille = libelleFamille;
    }

    public Boolean getSupprime() {
        return supprime;
    }

    public void setSupprime(Boolean supprime) {
        this.supprime = supprime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idFamille);
        hash = 67 * hash + Objects.hashCode(this.libelleFamille);
        hash = 67 * hash + Objects.hashCode(this.supprime);
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
        final Famille other = (Famille) obj;
        if (!Objects.equals(this.idFamille, other.idFamille)) {
            return false;
        }
        if (!Objects.equals(this.libelleFamille, other.libelleFamille)) {
            return false;
        }
        if (!Objects.equals(this.supprime, other.supprime)) {
            return false;
        }
        return true;
    }
	
    private static final Logger LOG = Logger.getLogger(Famille.class.getName());

    @Override
    public String toString() {
        return "Famille{" + "idFamille=" + idFamille + ", libelleFamille=" + libelleFamille + ", supprime=" + supprime + '}';
    }
    
    
}

   
