package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.Entities.PharmaProdID;
import com.deenech.gest_el_act.Entities.Pharmacie;
import com.deenech.gest_el_act.Entities.Produit;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-25T00:22:37")
@StaticMetamodel(PharmaProd.class)
public class PharmaProd_ { 

    public static volatile SingularAttribute<PharmaProd, Produit> Prod;
    public static volatile SingularAttribute<PharmaProd, Pharmacie> Pharma;
    public static volatile SingularAttribute<PharmaProd, PharmaProdID> idPharmaProd;

}