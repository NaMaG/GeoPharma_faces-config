/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.ImplementServices;

import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.DAO.ProduitIDAO;
import com.deenech.gest_el_act.Entities.Produit;
import com.deenech.gest_el_act.Services.ProduitService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class ProduitServiceImpl extends BaseServiceBeanImpl<Produit, Long> implements ProduitService{
    
    
      @EJB
    private ProduitIDAO dao;

    @Override
    protected BaseDaoBean<Produit, Long> getDao() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return dao;
    }
}


