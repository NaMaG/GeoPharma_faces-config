package com.deenech.gest_el_act.ImplementDAO;

import com.deenech.gest_el_act.DAO.PharmaProdIDAO;
import com.deenech.gest_el_act.Entities.PharmaProd;

import javax.ejb.Stateless;

/**
 *
 * @author NaMaG
 */

@Stateless
public class PharmaProdDAOImpl extends BaseDaoBeanImpl<PharmaProd, Long> implements PharmaProdIDAO{
   
    public PharmaProdDAOImpl(){
        super(PharmaProd.class);
    }
    
}
