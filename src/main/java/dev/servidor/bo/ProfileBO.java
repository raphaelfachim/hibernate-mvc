package dev.servidor.bo;

import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.bean.Profile;
import dev.servidor.dao.implementation.ProfileDAO;

public class ProfileBO {
    
    private static final TransactionManager tm = new TransactionManager();
    
    private static final ProfileDAO profileDao = new ProfileDAO();
    
    public static void saveProfile(Profile profile){
        try {
//            System.out.println(profile.getName() + " " + profile.getLastName());
           tm.beginTransaction();
           tm.getSession().save(profile);
           tm.commit();
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
