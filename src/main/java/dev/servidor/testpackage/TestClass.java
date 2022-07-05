package dev.servidor.testpackage;

import dev.servidor.bean.Message;
import dev.servidor.bean.Profile;
import dev.servidor.bo.MessageBO;
import dev.servidor.bo.ProfileBO;
import dev.servidor.dto.ProfileDTO;
import dev.servidor.model.UserViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
            UserViewModel userViewModel = new UserViewModel();
            
            ProfileBO profileBo = new ProfileBO(userViewModel.getTm());
            MessageBO messageBo = new MessageBO(userViewModel.getTm());
            
            Profile lucas = userViewModel.saveProfile(profileBo.crateProfile("Lucas", "Pereira", "22/05/1998"));
//            List<Message> messages = new ArrayList<Message>();
//            
//            Message m1 = userViewModel.createMessage("Message 1", profileBo.createProfileDTO(lucas));
//            Message m2 = userViewModel.createMessage("Message 2", profileBo.createProfileDTO(lucas));
//            Message m3 = userViewModel.createMessage("Message 3", profileBo.createProfileDTO(lucas));
//            
//            messages.addAll(Arrays.asList(m1,m2,m3));
            userViewModel.saveMessage(messageBo.createMessage("Message 4", lucas));
            
            
//            ProfileDTO profile = userViewModel.getProfileByFullName("Lucas Pereira");
//            userViewModel.saveMessage(messageBo.createMessage("Mensagem de Lucas Pereira", profile));
            userViewModel.getTm().closeSessionFactory();
	}
	
}
