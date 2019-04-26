/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.ImplementServices;



import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.ImplementServices.BaseServiceBeanImpl;
import com.deenech.gest_el_act.usermodule.DAO.IUtilisateurDAO;
import com.deenech.gest_el_act.usermodule.Services.UtilisateurService;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class UtilisateurSessionBean extends BaseServiceBeanImpl<Utilisateur, Long> implements UtilisateurService {

    @EJB
    private IUtilisateurDAO dao;

    @Override
    protected BaseDaoBean<Utilisateur, Long> getDao() {
        return dao;
    }
    
    @Override
    public List<Utilisateur> getNonSupprime(String attribut, Boolean state) {
        return dao.getNonSupprime(attribut,state);
    }
}
