/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.ImplementServices;

import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.DAO.ExemplaireIDAO;
import com.deenech.gest_el_act.Entities.Exemplaire;
import com.deenech.gest_el_act.Services.ExemplaireService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class ExemplaireServiceImpl extends BaseServiceBeanImpl<Exemplaire, Long> implements ExemplaireService{
    
    
      @EJB
    private ExemplaireIDAO dao;

    @Override
    protected BaseDaoBean<Exemplaire, Long> getDao() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return dao;
    }
}


