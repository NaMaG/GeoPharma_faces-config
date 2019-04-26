/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Filter;

import java.io.Serializable;

/**
 *
 * @author Mikel
 */

public abstract class constante implements Serializable{
    
    public static final String ROLE_ALL = "Tous";
    public static final String ROLE_ALL_CLE = "Master";
    
    public static final String ROLE_ADMIN = "Administrateur";
    public static final String ROLE_ADMIN_CLE = "All";
    
    public static final String MOT_DE_PASSE_DEFAUT = "admin";

    public constante() {
    }
   
}
