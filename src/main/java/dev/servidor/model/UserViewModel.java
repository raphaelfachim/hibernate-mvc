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
import dev.servidor.dto.MessageDTO;
import dev.servidor.dto.ProfileDTO;
import java.util.Collection;
import java.util.List;

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
            System.out.println("Erro no m�todo saveProfile [UserViewModel] " + ex);
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
            System.out.println("Erro no m�todo saveMessage [UserViewModel]");
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
            System.out.println("Erro no m�todo saveAllMessages [UserViewModel]");
            ex.printStackTrace();
        } finally {
            tm.closeSession();
        }
    }
    
//    public Message createMessage(String message, ProfileDTO profileDTO){
//        Message mes;
//        try{
//            tm.openSession();
//            tm.beginTransaction();
//            mes = messageBo.createMessage(message, profileDTO);
//            tm.commit();
//            return mes;
//        } catch(Exception ex){
//            tm.rollback();
//            System.out.println("Erro no m�todo createMessage [UserViewModel]");
//            return null;
//        } finally {
//            tm.closeSession();
//        }
//    }
    
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
            System.out.println("Erro no m�todo getProfileById [UserViewModel] " + ex);
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
            System.out.println("Erro no m�todo getProfileByFullName [UserViewModel] " + ex);;
            return null;
        } finally {
            tm.closeSession();
        }
    }
    
     public List<ProfileDTO> getAllProfiles(){
        List<ProfileDTO> profiles;
        try{
            tm.openSession();
            tm.beginTransaction();
            profiles = profileBo.getAllProfiles();
            tm.commit();
            return profiles;
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no m�todo getAllProfiles [UserViewModel] " + ex);;
            return null;
        } finally {
            tm.closeSession();
        }
    }
     
    public List<MessageDTO> getMessagesByProfile(ProfileDTO profileDTO){
        List<MessageDTO> messages;
        try{
            tm.openSession();
            tm.beginTransaction();
            messages = profileBo.getMessages(profileDTO);
            tm.commit();
            for(MessageDTO messageDTO : messages){
                System.out.println(messageDTO.getMessage());
            }
            return messages;
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no m�todo getMessagesByProfile [UserViewModel] " + ex);;
            return null;
        } finally {
            tm.closeSession();
        }
    }
    
    public void postNewMessage(ProfileDTO profileDTO, MessageDTO messageDTO){
        try{
            tm.openSession();
            tm.beginTransaction();
            profileBo.postNewMessage(profileDTO, messageDTO);
            tm.commit();
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no m�todo postNewMessage [UserViewModel] " + ex);;
        } finally {
            tm.closeSession();
        }
    }

    public TransactionManager getTm() {
        return tm;
    }
    
}
