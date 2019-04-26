/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.ImplementServices;

import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.DAO.PharmacieIDAO;
import com.deenech.gest_el_act.Entities.Pharmacie;
import com.deenech.gest_el_act.Services.PharmacieService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class PharmacieServiceImpl extends BaseServiceBeanImpl<Pharmacie, Long> implements PharmacieService{
    
    
      @EJB
    private PharmacieIDAO dao;

    @Override
    protected BaseDaoBean<Pharmacie, Long> getDao() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return dao;
    }
}


