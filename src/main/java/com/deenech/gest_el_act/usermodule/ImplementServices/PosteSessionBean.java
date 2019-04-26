/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.ImplementServices;


import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.ImplementServices.BaseServiceBeanImpl;
import com.deenech.gest_el_act.usermodule.DAO.IPosteDAO;
import com.deenech.gest_el_act.usermodule.Services.PosteService;
import com.deenech.gest_el_act.usermodule.entities.Poste;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class PosteSessionBean extends BaseServiceBeanImpl<Poste, Long> implements PosteService {

    @EJB
    private IPosteDAO dao;

    @Override
    protected BaseDaoBean<Poste, Long> getDao() {
        return dao;
    }
}
