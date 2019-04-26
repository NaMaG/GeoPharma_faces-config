/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.ImplementServices;



import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.ImplementServices.BaseServiceBeanImpl;
import com.deenech.gest_el_act.usermodule.DAO.IDroitDAO;
import com.deenech.gest_el_act.usermodule.Services.DroitService;
import com.deenech.gest_el_act.usermodule.entities.Droit;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class DroitSessionBean extends BaseServiceBeanImpl<Droit, Long> implements DroitService {

    @EJB
    private IDroitDAO dao;

    @Override
    protected BaseDaoBean<Droit, Long> getDao() {
        return dao;
    }
}
