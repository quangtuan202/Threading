import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Main {
    public static Date getDateFullFormat2(String string) {
        Date date = null;
        //SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = formatter.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public  static String[] localTimeToUTC(Date localDateTime) {
        String[] timeString;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = simpleDateFormat.format(localDateTime);
        timeString=utcTime.split(" ");
        return timeString;
    }

    public static  String[] utcToLocalDateTime(Date utcDateTime) {
        String[] timeString=new String[3];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date localDateTime = new Date(utcDateTime.getTime() + TimeZone.getTimeZone(timeZone).getOffset(utcDateTime.getTime()));
        String localDateTimeString = simpleDateFormat.format(localDateTime);
        timeString=localDateTimeString.split(" ");
        return timeString;
    }

    public static long getMillis(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date localDateTime = null;
        try {
            localDateTime = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return localDateTime.getTime();
    }



//    public static String getDatetimeNow() {
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
//        String utcTime = simpleDateFormat.format(calendar.getTime());
//        return utcTime;
//    }

    public static Date getUTCDate(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDateTime = null;
        try {
            utcDateTime = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utcDateTime;
    }

    public static void generateHash(String password) {
        MessageDigest md = null;
        String base64 = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            base64 = Base64.getEncoder().encodeToString(byteData);


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        System.out.println(password.getBytes());
        System.out.println(base64);
    }


    public static String getStringDateFormat(String dateString) {
        String dateStringDayFirst="";
        SimpleDateFormat formatterYearFirst = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatterDayFirst = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            dateStringDayFirst = formatterDayFirst.format(formatterYearFirst.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateStringDayFirst;
    }


    public Date getDateFormat2(String string) {
        Date date = null;
        //SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String[] getDatetimeNow() {
        // return an 3-item array
        //1st Date , 2nd time, 3rd date & time
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = simpleDateFormat.format(calendar.getTime());
        String[] dateArrayThreeItem=new String[3];
        String[] dateArrayTwoItem=utcTime.split(" ");
        dateArrayThreeItem[0]=dateArrayTwoItem[0];
        dateArrayThreeItem[1]=dateArrayTwoItem[1];
        dateArrayThreeItem[2]=utcTime;
        return dateArrayThreeItem;
    }

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String timeZone = Calendar.getInstance().getTimeZone().getID();
////        Date localDateTime = new Date(utcDateTime.getTime() + TimeZone.getTimeZone(timeZone).getOffset(utcDateTime.getTime()));
//
//
//        String time_string="2022-04-06 16:20:30";
//        String time_string2="2022-04-06 14:20:31";
////        System.out.println(getDateFullFormat2(time_string).getTime());
////        System.out.println(getDateFullFormat2(time_string2).getTime());
////        System.out.println(getMillis(time_string2));
//////        System.out.println(getMillis(time_string));
//        Date date=new Date();
//        System.out.println(date.getTime());
//        System.out.println(getUTCDate("2022-04-06 09:53:00"));

//        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        final SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        format.setTimeZone(TimeZone.getTimeZone("UTC"));
//        System.out.println(format.parse("1970-01-01 00:00:00 ITC"));
//        System.out.println(format2.parse("1970-01-01 00:00:00 ITC"));
////        System.out.println(getMillis("1970-01-01 00:00:00"));
//        System.out.println(getStringDateFormat("1970-01-01 00:00:00"));
////        generateHash("123456");
//
//        long millis=getMillis("1970-01-01 00:00:00");
//        Date activeGrowthEndDateTime = new Date(millis);
//        System.out.println(activeGrowthEndDateTime);
//
//        String activeGrowthEndTimeUTC = localTimeToUTC(activeGrowthEndDateTime)[0] + " " + localTimeToUTC(activeGrowthEndDateTime)[1];
//        System.out.println(activeGrowthEndTimeUTC);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
        Date date= dateFormat.parse("2022-04-07");
        Date timeStart=timeFormat.parse("11:00:00");
        System.out.println("timeStart "+timeStart);
        System.out.println("date "+date);
//        String[] dateArray=utcToLocalDateTime(date,timeStart);


        Date[] dateArray=utcToLocalDateTimeDateType(date,timeStart);
        System.out.println(dateArray[0]);
        System.out.println(dateArray[1]);

        System.out.println(utcToLocalDateTime(dateArray[0],dateArray[1])[0]);
        System.out.println(utcToLocalDateTime(dateArray[0],dateArray[1])[1]);
//        System.out.println(getDatetimeNow()[2]);


    }

    public static Date[] utcToLocalDateTimeDateType(Date utcDate,Date utcTime)  {

        Calendar calDate = Calendar.getInstance();
        Calendar calTime = Calendar.getInstance();
        Calendar calDateTime = Calendar.getInstance();
        calDate.setTime(utcDate);
        calTime.setTime(utcTime);

        calDateTime.set(Calendar.DAY_OF_MONTH, calDate.get(Calendar.DAY_OF_MONTH));
        calDateTime.set(Calendar.MONTH, calDate.get(Calendar.MONTH));
        calDateTime.set(Calendar.YEAR, calDate.get(Calendar.YEAR));
        calDateTime.set(Calendar.HOUR_OF_DAY, calTime.get(Calendar.HOUR_OF_DAY));
        calDateTime.set(Calendar.MINUTE, calTime.get(Calendar.MINUTE));
        calDateTime.set(Calendar.SECOND, calTime.get(Calendar.SECOND));
        Date utcDateTime=calDateTime.getTime();

        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date localDateTime = new Date(utcDateTime.getTime() + TimeZone.getTimeZone(timeZone).getOffset(utcDateTime.getTime()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        Date datePortion=null;
        Date timePortion=null;
        try {
            datePortion=dateFormat.parse(dateFormat.format(localDateTime));
            timePortion=timeFormat.parse(timeFormat.format(localDateTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Date[] {datePortion,timePortion};
    }

        public static Date[] localDateTimeToUTC(Date localDate,Date localTime)  {
            Calendar calDate = Calendar.getInstance();
            Calendar calTime = Calendar.getInstance();
            Calendar calDateTime = Calendar.getInstance();
            calDate.setTime(localDate);
            calTime.setTime(localTime);

            calDateTime.set(Calendar.DAY_OF_MONTH, calDate.get(Calendar.DAY_OF_MONTH));
            calDateTime.set(Calendar.MONTH, calDate.get(Calendar.MONTH));
            calDateTime.set(Calendar.YEAR, calDate.get(Calendar.YEAR));
            calDateTime.set(Calendar.HOUR_OF_DAY, calTime.get(Calendar.HOUR_OF_DAY)); // use HOUR_OF_DAY for 24h format
            calDateTime.set(Calendar.MINUTE, calTime.get(Calendar.MINUTE));
            calDateTime.set(Calendar.SECOND, calTime.get(Calendar.SECOND));

            Date localDateTime=calDateTime.getTime();

            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String utcTime=dateTimeFormat.format(localDateTime);
            String[] utcDateTimeString=utcTime.split(" ");

            Date datePortion=null;
            Date timePortion=null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                datePortion=dateFormat.parse(utcDateTimeString[0]);
                timePortion=timeFormat.parse(utcDateTimeString[1]);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        return new Date[] {datePortion,timePortion};
    }


    public  String[] localDateTimeToUTC(String localDate,String localTime ) {
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



    public static String[] utcToLocalDateTime(Date utcDate,Date utcTime)  {

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
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String stringDatePortion = dateFormat.format(localDateTime);
        String stringTimePortion = timeFormat.format(localDateTime);

        return new String[] {stringDatePortion,stringTimePortion};

    }




    public static String getDateOrTime(String dateTimeString,boolean dateOnly){
        String[] dateTimeList=dateTimeString.split(" ");
        dateTimeList[0]=dateTimeList[0].trim();
        dateTimeList[1]=dateTimeList[1].trim();
        if (dateOnly){

            return dateTimeList[0];
        }
        return dateTimeList[1];
    }

}
