/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.servidor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    
    public static Date getDateFromString(String dateString) throws ParseException{
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return fmt.parse(dateString);
    }
}
