import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        //4.1
        System.out.println("Задание 4.1");
        System.out.println("Введите строку");
        Scanner in = new Scanner(System.in);
        String strMain = in.nextLine();
        System.out.println("Введите подстроку");
        String strSec = in.nextLine();
        int count = 0;
        int index = 0;
        while (true) {
            index = strMain.indexOf(strSec, index);
            if (index != -1) {
                count++;
                index++;
            } else {
                break;
            }
        }
        System.out.println("Подстрока '" + strSec + "' встречается " + count + " раза");

        //4.2
        System.out.println("Задание 4.2");
        System.out.println("Введите строку");
        strMain = in.nextLine();
        strMain = strMain.replaceAll("бяка","вырезано цензурой");
        strMain = strMain.replaceAll("кака","вырезано цензурой");
        System.out.println(strMain);

        //4.3
        System.out.println("Задание 4.3");
        System.out.println("Введите дату в формате 'дд.мм.гггг'");
        strMain = in.nextLine();
        strSec = strMain;
        strMain = strMain.substring(6,10) + "-" + strMain.substring(3,5) + "-" + strMain.substring(0,2);
        System.out.println(strMain);

        //4.4
        System.out.println("Задание 4.4");
        SimpleDateFormat inDate = new SimpleDateFormat ("dd.MM.yyyy");
        SimpleDateFormat outDate = new SimpleDateFormat ("yyyy-MM-dd");
        Date date = inDate.parse(strSec);
        System.out.println(outDate.format(date));
    }
}