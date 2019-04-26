
package com.deenech.gest_el_act.Parameters;

import javax.naming.InitialContext;
import javax.transaction.UserTransaction;


public class TransactionManager {

    public TransactionManager() {
    }

    public static UserTransaction getUserTransaction() {
        UserTransaction utx;
        try {
            InitialContext context = new InitialContext();
            utx = (UserTransaction) context.lookup("java:comp/UserTransaction");
            return utx;
        } catch (Exception e) {
            return null;
        }
    }
}
