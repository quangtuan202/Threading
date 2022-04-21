import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class localtoUtc {

    public  static String[] localTimeToUTC(Date localDateTime) {
        String[] timeString;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = simpleDateFormat.format(localDateTime);
        timeString=utcTime.split(" ");
        return timeString;
    }

    public  static String[] localDateTimeToUTC(String localDate,String localTime ) {
        String[] timeString;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date localDateTime = null;
        try {
            localDateTime = simpleDateFormat.parse(localDate+" "+localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = simpleDateFormat.format(localDateTime);
        timeString=utcTime.split(" ");
        return timeString;
    }

    public static void main(String[] args) {
        final String LOCAL_START_TIME_OF_DAY="00:00:00";
        final String LOCAL_END_TIME_OF_DAY="24:00:00";
//        Date date=new Date();
//        String[] localTimeToUTC=localTimeToUTC(date);
//        System.out.println(localTimeToUTC[0]);
//        System.out.println(localTimeToUTC[1]);

        String[] localTimeToUTC=localDateTimeToUTC("2022-04-14","00:00:00");
        System.out.println(localTimeToUTC[0]);
        System.out.println(localTimeToUTC[1]);
        String TABLE_RECORD_NAME="record";
        String USER_ID="user";
        String userID="a";
        String ACTIVITIES_ID="ACTIVITIES_ID";
        String activityID="10";
        String RECORD_DATE_END="RECORD_DATE_END";
        String utcFirstDate="utcFirstDate";
        String RECORD_TIME_END="RECORD_TIME_END";
        String utcFirstDateAndStartTime="utcFirstDateAndStartTime";
        String utcLastDate="utcLastDate";
        String utcLastDateAndEndTime="utcLastDateAndEndTime";

        String selectQuery =" SELECT "+" * "+" FROM "+TABLE_RECORD_NAME+" WHERE "+USER_ID+" = "+"'"+userID+"'"+" AND "+" ( "+RECORD_DATE_END+" || "+"' '"+" || "+RECORD_TIME_END+" >= "+"'"+utcFirstDateAndStartTime+"'"+" ) "+" AND "+" ( "+RECORD_DATE_END+" || "+"' '"+" || "+RECORD_TIME_END+" <= "+"'"+utcLastDateAndEndTime+"'"+" ) "+" ORDER "+" BY "+RECORD_DATE_END+" DESC "+" , "+RECORD_TIME_END+" DESC ";

        System.out.println(selectQuery);
    }
}
