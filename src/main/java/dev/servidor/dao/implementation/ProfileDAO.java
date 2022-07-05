package dev.servidor.dao.implementation;

import dev.servidor.bean.Profile;
import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.dao.GenericDAO;
import dev.servidor.dao.interfaces.IProfileDAO;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ProfileDAO extends GenericDAO implements IProfileDAO{
    
    public Profile getProfileById(TransactionManager tm, Long profileId){
        return (Profile) tm.getSession().get(Profile.class, profileId);
    }
    
    public Profile getProfileByFullName(TransactionManager tm, String fullName){
        System.out.println("[getProfileByFullName] Begin method");
        String name;
        String lastName;
        
        String n[] = fullName.split("\\s", 2);
        
        name = n[0];
        lastName = n[1];
        
        Criteria criteria;
        try {
            criteria = tm.getSession().createCriteria(Profile.class, "profile");
            
            criteria.add(Restrictions.eq("profile.name", name));
            criteria.add(Restrictions.eq("profile.lastName", lastName));
            
            return (Profile) criteria.uniqueResult();
            
        } catch(Exception ex){
            System.err.println("[getProfileByFullName]" + ex);
            return null;
        }   
    }
}
