import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Как тебя зовут?");
        Scanner in = new Scanner(System.in);
        String name  = in.next();
        System.out.println("Привет, " + name);
    }
}