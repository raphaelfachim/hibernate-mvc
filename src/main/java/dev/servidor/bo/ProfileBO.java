package dev.servidor.bo;

import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.bean.Profile;
import dev.servidor.dao.implementation.ProfileDAO;
import dev.servidor.dto.ProfileDTO;

public class ProfileBO {
    
    private static final ProfileDAO profileDao = new ProfileDAO();
    
    public static void saveProfile(TransactionManager tm, Profile profile){
           tm.getSession().save(profile);
    }

    public static ProfileDTO getProfileById(TransactionManager tm, Long profileId) {
        System.out.println("Início do método [getProfileById]");
        Profile profile = (Profile) tm.getSession().get(Profile.class, profileId);
        ProfileDTO profileDto = new ProfileDTO();
        profileDto.setFullName(profile.getName() + " " + profile.getLastName());
        return profileDto;
    }
}
