package com.deenech.gest_el_act.ImplementDAO;

import com.deenech.gest_el_act.DAO.FamilleIDAO;
import com.deenech.gest_el_act.Entities.Famille;

import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class FamilleDAOImpl extends BaseDaoBeanImpl<Famille, Long> implements FamilleIDAO{
   
    public FamilleDAOImpl(){
        super(Famille.class);
    }
    
}
