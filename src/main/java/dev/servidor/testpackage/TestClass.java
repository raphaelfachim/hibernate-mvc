package dev.servidor.testpackage;

import dev.servidor.bean.Message;
import dev.servidor.bean.Profile;
import dev.servidor.bo.ProfileBO;
import dev.servidor.model.UserViewModel;

public class TestClass {

	public static void main(String[] args) {
            Profile profile1 = new Profile();

            profile1.setName("João");
            profile1.setLastName("da Silva");

            UserViewModel.save(profile1);
 
	}
	
}
