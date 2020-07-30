package company;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FiscalYear {

public String getCurrentYear() {
        Date date = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        String year = "" + cal.get(Calendar.YEAR);
        return year.substring(2); // last two digits
    }

    public String getCurrentMonth() {
        Date date = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        String sMonth;
        switch (month) {
            case 1:
                sMonth = "Jan";
                break;
            case 2:
                sMonth = "Feb";
                break;
            case 3:
                sMonth = "Mar";
                break;
            case 4:
                sMonth = "Apr";
                break;
            case 5:
                sMonth = "May";
                break;
            case 6:
                sMonth = "Jun";
                break;
            case 7:
                sMonth = "Jul";
                break;
            case 8:
                sMonth = "Aug";
                break;
            case 9:
                sMonth = "Sep";
                break;
            case 10:
                sMonth = "Oct";
                break;
            case 11:
                sMonth = "Nov";
                break;
            case 12:
                sMonth = "Dec";
                break;
            default:
                sMonth = "null";
        }
        return sMonth;
    }


}
