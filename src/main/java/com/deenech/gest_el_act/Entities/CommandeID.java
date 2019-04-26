/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deenech.gest_el_act.Entities;
import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;
import javax.persistence.Embeddable;

@Embeddable
public class CommandeID implements Serializable{
   private Long idUser;
   private Long idExemplaire;

public CommandeID(){
}

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(Long idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idUser);
        hash = 79 * hash + Objects.hashCode(this.idExemplaire);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CommandeID other = (CommandeID) obj;
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        if (!Objects.equals(this.idExemplaire, other.idExemplaire)) {
            return false;
        }
        return true;
    }
    private static final Logger LOG = Logger.getLogger(CommandeID.class.getName());

    @Override
    public String toString() {
        return "CommandeID{" + "idUser=" + idUser + ", idExemplaire=" + idExemplaire + '}';
    }


}
    
