package com.deenech.gest_el_act.ImplementDAO;

import com.deenech.gest_el_act.DAO.PharmacieIDAO;
import com.deenech.gest_el_act.Entities.Pharmacie;

import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class PharmacieDAOImpl extends BaseDaoBeanImpl<Pharmacie, Long> implements PharmacieIDAO{
   
    public PharmacieDAOImpl(){
        super(Pharmacie.class);
    }
    
}
