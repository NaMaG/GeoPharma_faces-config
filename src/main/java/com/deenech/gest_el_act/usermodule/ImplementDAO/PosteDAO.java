/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.usermodule.ImplementDAO;




import com.deenech.gest_el_act.ImplementDAO.BaseDaoBeanImpl;
import com.deenech.gest_el_act.usermodule.DAO.IPosteDAO;
import com.deenech.gest_el_act.usermodule.entities.Poste;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class PosteDAO extends BaseDaoBeanImpl<Poste, Long> implements IPosteDAO {

    public PosteDAO() {
        super(Poste.class);
    }
    
}
