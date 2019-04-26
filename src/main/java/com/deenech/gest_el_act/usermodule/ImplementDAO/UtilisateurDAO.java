/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.ImplementDAO;



import com.deenech.gest_el_act.ImplementDAO.BaseDaoBeanImpl;
import com.deenech.gest_el_act.Parameters.Mtm;
import com.deenech.gest_el_act.usermodule.DAO.IUtilisateurDAO;
import com.deenech.gest_el_act.usermodule.entities.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mikel
 */
@Stateless
public class UtilisateurDAO extends BaseDaoBeanImpl<Utilisateur, Long> implements IUtilisateurDAO {

    public UtilisateurDAO() {
        super(Utilisateur.class);
    }
    
    @Override
    public List<Utilisateur> getNonSupprime(String attribut,Boolean state) {
        try {
            TypedQuery<Utilisateur> requete = em.createQuery("SELECT t from Utilisateurs t where t.login <> :a and t.supprime = :b ", Utilisateur.class);
            requete.setParameter("a", attribut);
            requete.setParameter("b", state);
            return requete.getResultList();
        } catch (Exception e) {
            Mtm.mikiMessageError();
            return null;
        }
    }
}
