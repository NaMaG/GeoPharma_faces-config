/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Entities;

/**
 *
 * @author NaMaG
 */

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Embeddable;

@Embeddable
public class PharmaProdID implements Serializable{
    
    private Long idPharma;
    private Long idProd;
      
    public PharmaProdID(){
    }

    public PharmaProdID(Long idPharma, Long idProd) {
        this.idPharma = idPharma;
        this.idProd = idProd;
    }

    public Long getIdPharma() {
        return idPharma;
    }

    public void setIdPharma(Long idPharma) {
        this.idPharma = idPharma;
    }

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idPharma);
        hash = 53 * hash + Objects.hashCode(this.idProd);
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
        final PharmaProdID other = (PharmaProdID) obj;
        if (!Objects.equals(this.idPharma, other.idPharma)) {
            return false;
        }
        if (!Objects.equals(this.idProd, other.idProd)) {
            return false;
        }
        return true;
    }
    private static final Logger LOG = Logger.getLogger(PharmaProdID.class.getName());

    @Override
    public String toString() {
        return "PharmaProdID{" + "idPharma=" + idPharma + ", idProd=" + idProd + '}';
    }
    
}
