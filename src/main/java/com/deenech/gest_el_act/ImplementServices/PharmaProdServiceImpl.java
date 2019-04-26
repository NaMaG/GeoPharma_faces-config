/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.ImplementServices;

import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.DAO.PharmaProdIDAO;
import com.deenech.gest_el_act.Entities.PharmaProd;
import com.deenech.gest_el_act.Services.PharmaProdService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class PharmaProdServiceImpl extends BaseServiceBeanImpl<PharmaProd, Long> implements PharmaProdService{
    
    
      @EJB
    private PharmaProdIDAO dao;

    @Override
    protected BaseDaoBean<PharmaProd, Long> getDao() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return dao;
    }
}


