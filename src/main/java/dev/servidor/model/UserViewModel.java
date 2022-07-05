/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.servidor.model;

import dev.servidor.bean.Message;
import dev.servidor.bean.Profile;
import dev.servidor.bo.MessageBO;
import dev.servidor.bo.ProfileBO;
import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.dto.ProfileDTO;
import java.util.Collection;

/**
 *
 * @author raphael.fachim
 */
public class UserViewModel {
    
    private static TransactionManager tm;
    
    private ProfileBO profileBo;
    
    private MessageBO messageBo;

    public UserViewModel() {
        this.tm = new TransactionManager();
        this.profileBo = new ProfileBO(tm);
        this.messageBo = new MessageBO(tm);
    }
    
    
    
    public Profile saveProfile(Profile profile){
        Profile newProfile;
        try{
            tm.openSession();
            tm.beginTransaction();
            newProfile = profileBo.saveProfile(profile);
            tm.commit();
            return newProfile;
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no método saveProfile [UserViewModel] " + ex);
            return null;
        } finally {
            tm.closeSession();
        }
    }
    
    public void saveMessage(Message message){
        try{
            tm.openSession();
            tm.beginTransaction();
            messageBo.saveMessage(message);
            tm.commit();
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no método saveMessage [UserViewModel]");
        } finally {
            tm.closeSession();
        }
    }
    
    public void saveAllMessages(Collection<Message> messages){
        try{
            tm.openSession();
            tm.beginTransaction();
            messageBo.saveAllMessages(messages);
            tm.commit();
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no método saveAllMessages [UserViewModel]");
            ex.printStackTrace();
        } finally {
            tm.closeSession();
        }
    }
    
    public Message createMessage(String message, ProfileDTO profileDTO){
        Message mes;
        try{
            tm.openSession();
            tm.beginTransaction();
            mes = messageBo.createMessage(message, profileDTO);
            tm.commit();
            return mes;
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no método createMessage [UserViewModel]");
            return null;
        } finally {
            tm.closeSession();
        }
    }
    
    public ProfileDTO getProfileById(Long profileId){
        ProfileDTO profile;
        try{
            tm.openSession();
            tm.beginTransaction();
            profile = profileBo.getProfileDTOById(profileId);
            tm.commit();
            return profile;
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no método getProfileById [UserViewModel] " + ex);
            return null;
        } finally {
            tm.closeSession();
        }
    }
    
    public ProfileDTO getProfileByFullName(String fullName){
        ProfileDTO profile;
        try{
            tm.openSession();
            tm.beginTransaction();
            profile = profileBo.getProfileByFullName(fullName);
            tm.commit();
            return profile;
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no método getProfileByFullName [UserViewModel] " + ex);;
            return null;
        } finally {
            tm.closeSession();
        }
    }

    public TransactionManager getTm() {
        return tm;
    }
    
}
