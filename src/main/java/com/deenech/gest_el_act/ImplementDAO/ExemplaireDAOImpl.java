package com.deenech.gest_el_act.ImplementDAO;

import com.deenech.gest_el_act.DAO.ExemplaireIDAO;
import com.deenech.gest_el_act.Entities.Exemplaire;

import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class ExemplaireDAOImpl extends BaseDaoBeanImpl<Exemplaire, Long> implements ExemplaireIDAO{
   
    public ExemplaireDAOImpl(){
        super(Exemplaire.class);
    }
    
}
