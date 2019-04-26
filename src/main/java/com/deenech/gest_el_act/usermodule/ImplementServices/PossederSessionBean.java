/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.ImplementServices;



import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.ImplementServices.BaseServiceBeanImpl;
import com.deenech.gest_el_act.usermodule.DAO.IPossederDAO;
import com.deenech.gest_el_act.usermodule.Services.PossederService;
import com.deenech.gest_el_act.usermodule.entities.Posseder;
import com.deenech.gest_el_act.usermodule.entities.PossederId;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class PossederSessionBean extends BaseServiceBeanImpl<Posseder, PossederId> implements PossederService {

    @EJB
    private IPossederDAO dao;

    @Override
    protected BaseDaoBean<Posseder, PossederId> getDao() {
        return dao;
    }
}
