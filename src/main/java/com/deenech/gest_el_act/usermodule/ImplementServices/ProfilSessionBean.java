/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.ImplementServices;




import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.ImplementServices.BaseServiceBeanImpl;
import com.deenech.gest_el_act.usermodule.DAO.IProfilDAO;
import com.deenech.gest_el_act.usermodule.Services.ProfilService;
import com.deenech.gest_el_act.usermodule.entities.Profil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class ProfilSessionBean extends BaseServiceBeanImpl<Profil, Long> implements ProfilService {

    @EJB
    private IProfilDAO dao;

    @Override
    protected BaseDaoBean<Profil, Long> getDao() {
        return dao;
    }
}
