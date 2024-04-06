import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите 3 числа");
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        String result = "";
        if (a % 5 == 0 && a != 0) System.out.println("a = " + a);
        if (b % 5 == 0 && b != 0) System.out.println("b = " + b);
        if (c % 5 == 0 && c != 0) System.out.println("c = " + c);
        System.out.println("Результат целочисленного деления a на b: " + a / b);
        System.out.println("Результат деления a на b: " + (double) a / b);
        System.out.println("Результат деления a на b с округлением в большую сторону: " + (int) Math.ceil((double) a / b));
        System.out.println("Результат деления a на b с округлением в меньшую сторону: " + (int) Math.floor((double) a / b));
        System.out.println("Результат деления a на b с математическим округлением: " + Math.round((double) a / b));
        System.out.println("Остаток от деления b на c: " + b % c);
        System.out.println("Наименьшее значение из a и b: " + Math.min(a, b));
        System.out.println("Наибольшее значение из b и c: " + Math.max(b, c));

    }
}