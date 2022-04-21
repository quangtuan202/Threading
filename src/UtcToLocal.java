import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class UtcToLocal {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=dateFormat.parse("2022-04-10");//Local
        Date date2=dateFormat.parse("2022-04-19");//Local
        Date utcDate=dateFormat.parse("2022-04-19"); //utc

        Date utcTime=timeFormat.parse("24:00:00"); // utc time
        
        Date utcToLocal=dateUTCToLocalDateTime(utcDate,utcTime);
        System.out.println(utcToLocal);
        System.out.println(isWithinRange(utcToLocal,date1,date2));




    }
    public static Date dateUTCToLocalDateTime(Date utcDate,Date utcTime)  {

        Calendar calDate = Calendar.getInstance();
        Calendar calTime = Calendar.getInstance();
        Calendar calDateTime = Calendar.getInstance();
        calDate.setTime(utcDate);
        calTime.setTime(utcTime);

        calDateTime.set(Calendar.DAY_OF_MONTH, calDate.get(Calendar.DAY_OF_MONTH));
        calDateTime.set(Calendar.MONTH, calDate.get(Calendar.MONTH));
        calDateTime.set(Calendar.YEAR, calDate.get(Calendar.YEAR));
        calDateTime.set(Calendar.HOUR_OF_DAY, calTime.get(Calendar.HOUR_OF_DAY)); // use HOUR_OF_DAY for 24h format
        calDateTime.set(Calendar.MINUTE, calTime.get(Calendar.MINUTE));
        calDateTime.set(Calendar.SECOND, calTime.get(Calendar.SECOND));
        Date utcDateTime=calDateTime.getTime();

        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date localDateTime = new Date(utcDateTime.getTime() + TimeZone.getTimeZone(timeZone).getOffset(utcDateTime.getTime()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date= dateFormat.format(localDateTime);
        try {
            Date newLocalDateTime=dateFormat.parse(date);
            return newLocalDateTime;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isWithinRange(Date testDate, Date date1, Date date2) {
        return !(testDate.before(date1) || testDate.after(date2));
    }




}
