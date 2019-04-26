/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Entities;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
/**
 *
 * @author NaMaG
 */

  @Entity
@Table(name = "PharmaProd")
public class PharmaProd  implements Serializable {

    @EmbeddedId
    private PharmaProdID idPharmaProd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPharma", nullable = false, insertable = false, updatable = false)
    private Pharmacie Pharma;

    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "idProd", nullable = false, insertable = false, updatable = false)
    private Produit Prod;
  
}
