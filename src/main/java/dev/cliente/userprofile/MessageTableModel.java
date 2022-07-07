/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.cliente.userprofile;

import dev.cliente.mainframe.*;
import dev.servidor.dto.MessageDTO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author raphael.fachim
 */
public class MessageTableModel extends AbstractTableModel{
    
    private static final int COLUMN_MESSAGE_TITLE = 0;
    private static final int COLUMN_DATE = 1;
    private static final int COLUMNS = 2;
    
    private static final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private List<MessageDTO> messages;
    
    public MessageTableModel(List<MessageDTO> messages) {
        this.messages = messages;
    }

    public int getRowCount() {
        return messages.size();
    }

    public int getColumnCount() {
        return COLUMNS;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        MessageDTO message = getMessages().get(rowIndex);
        switch(columnIndex){
            case COLUMN_MESSAGE_TITLE:
                return message.getMessage();
            case COLUMN_DATE:
                return message.getCreated();
            default:
                return null;
        }
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
    }
    
}
