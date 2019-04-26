package com.deenech.gest_el_act.Services;

import com.deenech.gest_el_act.Entities.Commande;

import javax.ejb.Local;

/**
 *
 * @author NaMaG
 */

@Local
public interface CommandeService extends BaseServiceBean<Commande, Long> {
    
}
