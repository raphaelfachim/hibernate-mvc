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
    
    private final TransactionManager tm;

    public ProfileBO(TransactionManager tm) {
        this.tm = tm;
    }

    public Profile saveProfile(Profile profile){
           return profileDao.save(tm, profile);
    }

    public ProfileDTO getProfileDTOById(Long profileId) {
        Profile profile = profileDao.getProfileById(tm, profileId);
        return createProfileDTO(profile);
    }
    
    public Profile getProfileById(Long profileId) {
        return profileDao.getProfileById(tm, profileId);
    }

    public ProfileDTO getProfileByFullName(String fullName) {
        Profile profile = profileDao.getProfileByFullName(tm, fullName);
        return createProfileDTO(profile);
    }
    
    public ProfileDTO createProfileDTO(Profile profile){
        ProfileDTO profileDTO = new ProfileDTO(
                profile.getId(),
                profile.getName() + " " + profile.getLastName(),
                profile.getCreationDate()
        );
        return profileDTO;
    }
    
    public Profile crateProfile(String name, String lastName, String dateOfBith){
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
