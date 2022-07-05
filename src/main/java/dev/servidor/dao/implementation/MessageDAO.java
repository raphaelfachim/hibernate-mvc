package dev.servidor.dao.implementation;

import dev.servidor.bean.Message;
import dev.servidor.bean.Profile;
import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.dao.GenericDAO;
import dev.servidor.dao.interfaces.IMessageDAO;
import java.util.Collection;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class MessageDAO extends GenericDAO implements IMessageDAO{

    public void save(TransactionManager tm, Message message){
        tm.getSession().save(message);
    }
    
    public void saveAll(TransactionManager tm, Collection<Message> messages){
        for(Message message : messages){
            save(tm, message);
        }

    }
    
    public Message getMessageById(TransactionManager tm, Long messageId) {
        return (Message) tm.getSession().get(Message.class, messageId);
    }

    public List<Message> getMessageByProfile(TransactionManager tm, Profile profile) {
        Criteria criteria;
        try{
            criteria = tm.getSession().createCriteria(Message.class, "message");
            criteria.createAlias("profile", "profile");
            criteria.add(Restrictions.eq("profile.id", profile.getId()));
            
            return criteria.list();
            
        } catch(Exception ex){
            System.err.println("[getMessageByProfile]" + ex);
            return null;
        }
    }

}
