package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.Entities.Activite;
import com.deenech.gest_el_act.Entities.Client;
import com.deenech.gest_el_act.usermodule.entities.PossederId;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T14:45:55")
@StaticMetamodel(ClientActivite.class)
public class ClientActivite_ { 

    public static volatile SingularAttribute<ClientActivite, Activite> Act;
    public static volatile SingularAttribute<ClientActivite, Client> Clt;
    public static volatile SingularAttribute<ClientActivite, PossederId> id;

}