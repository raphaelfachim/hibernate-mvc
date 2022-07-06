package dev.servidor.bo;

import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.bean.Profile;
import dev.servidor.dao.implementation.ProfileDAO;
import dev.servidor.dto.ProfileDTO;
import dev.servidor.util.DateUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                profile.getCreationDate(),
                profile.getBirthDate()
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

    public List<ProfileDTO> getAllProfiles() {
        List<ProfileDTO> profiles = new ArrayList<ProfileDTO>();
        for(Profile profile : profileDao.getAllProfiles(tm)){
            profiles.add(createProfileDTO(profile));
        }
        return profiles;
    }
}
