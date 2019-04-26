package com.deenech.gest_el_act.Entities;

import com.deenech.gest_el_act.Entities.Client;
import com.deenech.gest_el_act.Entities.TypePiece;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-11T14:45:55")
@StaticMetamodel(Piece.class)
public class Piece_ { 

    public static volatile SingularAttribute<Piece, TypePiece> Type;
    public static volatile SingularAttribute<Piece, String> lien;
    public static volatile SingularAttribute<Piece, Long> idPiece;
    public static volatile SingularAttribute<Piece, Client> Clt;
    public static volatile SingularAttribute<Piece, String> designation;
    public static volatile SingularAttribute<Piece, Date> dateApport;
    public static volatile SingularAttribute<Piece, Boolean> supprime;

}