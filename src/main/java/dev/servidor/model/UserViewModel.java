/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.servidor.model;

import dev.servidor.bean.Profile;
import dev.servidor.bo.ProfileBO;
import dev.servidor.bo.transactionmanager.TransactionManager;
import dev.servidor.dto.ProfileDTO;

/**
 *
 * @author raphael.fachim
 */
public class UserViewModel {
    
    private static final TransactionManager tm = new TransactionManager();
    
    public static void save(Profile profile){
        try{
            tm.beginTransaction();
            ProfileBO.saveProfile(tm, profile);
            tm.commit();
        } catch(Exception ex){
            tm.rollback();
            System.out.println("Erro no método save [UserViewModel] " + ex);
        } 
    }
    
    public static ProfileDTO getProfile(Long profileId){
        ProfileDTO profile;
        try{
            tm.beginTransaction();
            profile = ProfileBO.getProfileById(tm, profileId);
            tm.commit();
            return profile;
        } catch(Exception ex){
            tm.rollback();
            System.out.println(ex);
            return null;
        } 
    }
}
