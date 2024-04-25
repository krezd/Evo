import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число a");
        double a = in.nextDouble();
        System.out.println("Введите число b");
        double b = in.nextDouble();
        Calculator calculator = new Calculator(new Adder());
        System.out.println("Результат сложения a и b: " + calculator.calc(a,b));
        Calculator calculator2 = new Calculator(new Subtractor());
        System.out.println("Результат вычитания a и b: " + calculator2.calc(a,b));

        Calculator calculator3 = new Calculator(new Multiplier());
        System.out.println("Результат умножения a и b: "+calculator3.calc(a,b));
        Calculator calculator4 = new Calculator(new Divider());
        System.out.println("Результат деления a и b: "+calculator4.calc(a,b));

    }
}