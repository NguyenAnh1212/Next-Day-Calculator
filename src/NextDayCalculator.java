public class NextDayCalculator {

    public static final String SLASH = "/";
    public static final int FIRSTDAYOFMONTH = 1;

    public static String getNextDay(int day, int month, int year) {
        int outputDay;
        int outputMonth = month;

        checkLeapyear(year);

        int lastDayOfMonth = getLastDayOfMonth(month, year);

        if(day == lastDayOfMonth){
            outputDay = FIRSTDAYOFMONTH;
            outputMonth = ++month;
        }else{
            outputDay = ++day;
            outputMonth = month;
        }
        String result = outputDay + SLASH + outputMonth +SLASH + year;
        return result;
    }

    private static boolean checkLeapyear(int year) {
        boolean check = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    check = true;
                }
            } else {
                check = true;
            }
        }
        return check;
    }


    private static int getLastDayOfMonth(int month, int year) {
        int lastDayOfMonth = 0;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastDayOfMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                lastDayOfMonth =30;
                break;
            case 2:
                if (checkLeapyear(year)){
                    lastDayOfMonth = 29;
                }else{
                    lastDayOfMonth = 28;
                }
                break;
        }
        return lastDayOfMonth;
    }
}
