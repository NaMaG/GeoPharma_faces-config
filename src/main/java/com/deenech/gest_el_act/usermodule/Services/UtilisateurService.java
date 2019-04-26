/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.Services;




import com.deenech.gest_el_act.Services.BaseServiceBean;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mikel
 */
@Local
public interface UtilisateurService extends BaseServiceBean<Utilisateur, Long>{
 
    public List<Utilisateur> getNonSupprime(String attribut, Boolean state);
}
