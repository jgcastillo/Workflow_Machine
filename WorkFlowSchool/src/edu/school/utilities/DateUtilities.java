package edu.school.utilities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author jgcastillo
 */
public class DateUtilities {

    public static Date localDateToDate(LocalDate ld){
        return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    public static LocalDate dateToLocalDate(Date date){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), 
                ZoneId.systemDefault()).toLocalDate();
    }
}
