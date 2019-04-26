/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.ImplementDAO;

import com.deenech.gest_el_act.DAO.ProduitIDAO;
import com.deenech.gest_el_act.Entities.Produit;

import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class ProduitDAOImpl extends BaseDaoBeanImpl<Produit, Long> implements ProduitIDAO{
   
    public ProduitDAOImpl(){
        super(Produit.class);
    }
    
}
