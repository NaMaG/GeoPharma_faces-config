package com.deenech.gest_el_act.ImplementDAO;

import com.deenech.gest_el_act.DAO.CommandeIDAO;
import com.deenech.gest_el_act.Entities.Commande;

import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class CommandeDAOImpl extends BaseDaoBeanImpl<Commande, Long> implements CommandeIDAO{
   
    public CommandeDAOImpl(){
        super(Commande.class);
    }
    
}
