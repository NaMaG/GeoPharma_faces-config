/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.ImplementServices;

import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.DAO.CommandeIDAO;
import com.deenech.gest_el_act.Entities.Commande;
import com.deenech.gest_el_act.Services.CommandeService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class CommandeServiceImpl extends BaseServiceBeanImpl<Commande, Long> implements CommandeService{
    
    
      @EJB
    private CommandeIDAO dao;

    @Override
    protected BaseDaoBean<Commande, Long> getDao() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return dao;
    }
}


