/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Managers;


import com.deenech.gest_el_act.Shiro.EntityRealm;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Faces;
//import org.omnifaces.util.Faces;

/**
 *
 * @author Mikel
 */

@ManagedBean(name = "ManagedBeanLogOut")
@RequestScoped

public class DeconnexionManager{

    public void deconnexionUser() throws IOException {
//        Mtm.logMikiLog4j(LogoutManagedBean.class.getName(), Level.INFO, "Deconnexion");
        EntityRealm.getSubject().logout();
        Faces.invalidateSession();
        Faces.redirect("index.xhtml");
    }
    
}