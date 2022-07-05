package dev.servidor.bo;

import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.bean.Profile;
import dev.servidor.dao.implementation.ProfileDAO;
import dev.servidor.dto.ProfileDTO;
import dev.servidor.util.DateUtils;
import java.text.ParseException;
import java.util.Date;

public class ProfileBO {
    
    private static final ProfileDAO profileDao = new ProfileDAO();
    
    public static void saveProfile(TransactionManager tm, Profile profile){
           tm.getSession().save(profile);
    }

    public static ProfileDTO getProfileById(TransactionManager tm, Long profileId) {
        Profile profile = profileDao.getProfileById(tm, profileId);
        return createProfileDTO(profile);
    }

    public static ProfileDTO getProfileByFullName(TransactionManager tm, String fullName) {
        Profile profile = profileDao.getProfileByFullName(tm, fullName);
        return createProfileDTO(profile);
    }
    
    public static ProfileDTO createProfileDTO(Profile profile){
        ProfileDTO profileDTO = new ProfileDTO(
                profile.getName() + " " + profile.getLastName(),
                profile.getCreationDate()
        );
        return profileDTO;
    }
    
    public static Profile crateProfile(String name, String lastName, String dateOfBith){
        Date birthDate;
        try{
            birthDate = DateUtils.getDateFromString(dateOfBith);
        } catch (ParseException parseEx) {
            birthDate = null;
        }
        return new Profile(
                name, lastName, new Date(), birthDate
        );
    }
}
