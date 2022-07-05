package dev.servidor.testpackage;

import dev.servidor.bean.Profile;
import dev.servidor.bo.ProfileBO;
import dev.servidor.dto.ProfileDTO;
import dev.servidor.model.UserViewModel;

public class TestClass {

	public static void main(String[] args) {
            UserViewModel.save(ProfileBO.crateProfile("Lucas", "Pereira", "22/05/1998"));
//            ProfileDTO profile = UserViewModel.getProfileByFullName("Maria Sousa Silva");
//            System.out.println(profile.getFullName());
 
	}
	
}
