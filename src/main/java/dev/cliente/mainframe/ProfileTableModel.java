/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.cliente.mainframe;

import dev.servidor.dto.ProfileDTO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author raphael.fachim
 */
public class ProfileTableModel extends AbstractTableModel{
    
    private static final int COLUMN_NAME = 0;
    private static final int COLUMN_LAST_NAME = 1;
    private static final int COLUMN_CREATION_DATE = 2;
    private static final int COLUMN_BIRTH_DATE = 3;
    private static final int COLUMN_ID = 4;
    private static final int COLUMNS = 5;
    
    private static final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private List<ProfileDTO> profiles;
    
    public ProfileTableModel(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }

    public int getRowCount() {
        return profiles.size();
    }

    public int getColumnCount() {
        return COLUMNS;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ProfileDTO profile = getProfiles().get(rowIndex);
        switch(columnIndex){
            case COLUMN_NAME:
                return profile.getFullName();
            case COLUMN_LAST_NAME:
                return "";
            case COLUMN_CREATION_DATE:
                return profile.getCreated() != null ? fmt.format(profile.getCreated()) : "";
            case COLUMN_BIRTH_DATE:
                return profile.getBithDate()!= null ? fmt.format(profile.getBithDate()) : "";
            case COLUMN_ID:
                return profile.getId();    
            default:
                return null;
        }
    }

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }
    
}
