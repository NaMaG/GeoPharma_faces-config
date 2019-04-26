/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Filter;

import java.io.Serializable;

/**
 *
 * @author Piero
 */
public abstract class parametres implements Serializable{
    
        
    public static final String piece1I = "CV";
    public static final String piece1L = "Curriculum Vitae";
    
    public static final String piece2I = "CIN";
    public static final String piece2L = "Carte d'identité Nationale";
    
    public static final String piece3I = "AD";
    public static final String piece3L = "Attestation de diplome";
    
    public static final String piece4I = "CV";
    public static final String piece4L = "Curriculum Vitae";

    public parametres() {
    }
    
}
