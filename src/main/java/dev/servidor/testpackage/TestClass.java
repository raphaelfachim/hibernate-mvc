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
            
//            Profile lucas = profileBo.crateProfile("Lucas", "Pereira", "22/05/1998");
            Profile raphael = profileBo.crateProfile("Raphael", "Fachim", "09/11/1998");
            Profile sara = profileBo.crateProfile("Sara", "Hansen", "04/03/1992");
            Profile bianca = profileBo.crateProfile("Bianca", "Andrade", "14/11/2000");
            Profile maria = profileBo.crateProfile("Maria", "de Lourdes", "07/08/2001");
            Profile joao = profileBo.crateProfile("João", "Santos", "19/01/1999");
//            Message mes1 = new Message();
//            mes1.setMessage("Mes 1");
//            
//            Message mes2 = new Message();
//            mes2.setMessage("Mes 2");
//            
//            lucas.addMessage(mes1);
//            lucas.addMessage(mes2);
//
//            userViewModel.saveProfile(lucas);
            userViewModel.saveProfile(raphael);
            userViewModel.saveProfile(sara);
            userViewModel.saveProfile(bianca);
            userViewModel.saveProfile(maria);
            userViewModel.saveProfile(joao);
//            List<Message> messages = new ArrayList<Message>();
//            
//            Message m1 = userViewModel.createMessage("Message 1", profileBo.createProfileDTO(lucas));
//            Message m2 = userViewModel.createMessage("Message 2", profileBo.createProfileDTO(lucas));
//            Message m3 = userViewModel.createMessage("Message 3", profileBo.createProfileDTO(lucas));
//            
//            messages.addAll(Arrays.asList(m1,m2,m3));
//            userViewModel.saveMessage(messageBo.createMessage("Message 4", lucas));
            
            
//            ProfileDTO profile = userViewModel.getProfileByFullName("Lucas Pereira");
//            userViewModel.saveMessage(messageBo.createMessage("Mensagem de Lucas Pereira", profile));
//            userViewModel.getAllProfiles();
            userViewModel.getTm().closeSessionFactory();
	}
	
}
