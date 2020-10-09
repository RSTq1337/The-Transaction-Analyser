package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    private static final SimpleDateFormat  dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static Date parse(String date){
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Error while parsing date");
        }
        return new Date();
    }

    public static boolean isDateToFrom(Date date, Date to, Date from){
        return date.after(from) && date.before(to);
    }

}
