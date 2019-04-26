/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.ImplementServices;

import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.DAO.FamilleIDAO;
import com.deenech.gest_el_act.Entities.Famille;
import com.deenech.gest_el_act.Services.FamilleService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class FamilleServiceImpl extends BaseServiceBeanImpl<Famille, Long> implements FamilleService{
    
    
      @EJB
    private FamilleIDAO dao;

    @Override
    protected BaseDaoBean<Famille, Long> getDao() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return dao;
    }
}


