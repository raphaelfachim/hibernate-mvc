package dev.servidor.bo;

import dev.servidor.bean.Message;
import dev.servidor.bean.Profile;
import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.dao.implementation.MessageDAO;
import dev.servidor.dto.MessageDTO;
import dev.servidor.dto.ProfileDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MessageBO {
    
    private static final MessageDAO messageDao = new MessageDAO();
    
    private ProfileBO profileBo;
    
    private final TransactionManager tm;

    public MessageBO(TransactionManager tm) {
        this.tm = tm;
        this.profileBo = new ProfileBO(tm);
    }
    
    public void saveMessage(Message message){
           messageDao.save(tm, message);
    }
    
    public void saveAllMessages(Collection<Message> messages){
           messageDao.saveAll(tm, messages);
    }

    public MessageDTO getMessageById(Long messageId) {
        Message message = messageDao.getMessageById(tm, messageId);
        return createMessageDTO(message);
    }

    public List<MessageDTO> getMessageByProfile(Profile profile) {
        List<MessageDTO> messages = new ArrayList<MessageDTO>();
        for(Message message : messageDao.getMessageByProfile(tm, profile)){
            messages.add(createMessageDTO(message));
        }
        return messages;           
    }
    
    public MessageDTO createMessageDTO(Message message){
        MessageDTO profileDTO = new MessageDTO(
                message.getProfile().getName() + " " + message.getProfile().getLastName(),
                message.getMessage(),
                message.getDate()
        );
        return profileDTO;
    }
    
    public Message createMessage(String message, ProfileDTO profileDTO){
        Profile profile = profileBo.getProfileById(profileDTO.getId());
        return new Message(
                message, profile, new Date()
        );
    }
    
    public Message createMessage(String message, Profile profile){
        return new Message(
                message, profile, new Date()
        );
    }
}
