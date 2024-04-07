import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите дату в формате 'dd.MM.yyyy'");
        String str = in.nextLine();
        SimpleDateFormat inDate = new SimpleDateFormat ("dd.MM.yyyy");
        Date date = inDate.parse(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,45);
        System.out.println("Дата после увеличения на 45 дней: " + inDate.format(calendar.getTime()));
        calendar.set(Calendar.YEAR,1900+date.getYear());
        calendar.set(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_YEAR,1);
        System.out.println("Дата после сдвига на начало года: " + inDate.format(calendar.getTime()));

        calendar.setTime(date);
        int workingDay = 10;

        while (workingDay > 0) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY ) {
                workingDay--;
            }
        }

        System.out.println("Дата после увеличения на 10 рабочих дней: " + inDate.format(calendar.getTime()));
        System.out.println("Введите вторую дату в формате 'dd.MM.yyyy'");
        String strSec = in.nextLine();
        Date date2 = inDate.parse(strSec);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        calendar.setTime(date);
        workingDay = 0;
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        if (date.before(date2)) {
            min.setTime(date);
            max.setTime(date2);
        } else {
            min.setTime(date2);
            max.setTime(date);
        }

        while (!min.equals(max)) {
            if (min.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && min.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY ) {
                workingDay++;
            }
            min.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("Количество рабочих дней между введенными датами: " + workingDay);


    }
}