/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.DAO;


import com.deenech.gest_el_act.DAO.BaseDaoBean;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.List;


/**
 *
 * @author Mikel
 */
public interface IUtilisateurDAO extends BaseDaoBean<Utilisateur, Long>{
 
    public List<Utilisateur> getNonSupprime(String attribut, Boolean state);
}
