package dev.servidor.testpackage;

import dev.servidor.bean.Message;
import dev.servidor.bean.Profile;
import dev.servidor.bo.ProfileBO;

public class TestClass {

	public static void main(String[] args) {
            Profile profile1 = new Profile();

            profile1.setName("João");
            profile1.setLastName("da Silva");

            ProfileBO.saveProfile(profile1);
            
            
	}
	
}
