import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        for(int i = 0; i < 5;i++){
            System.out.println("Введите имя пользователя");
            System.out.flush();
            String name = in.next();
            System.out.println("Введите возраст пользователя");
            System.out.flush();
            int age = in.nextInt();
            User user = new User(name, age);
            users.add(user);
        }
        Collections.sort(users);
        for (int i = 0; i < 5;i++){
            System.out.println(users.get(i).toString());
        }


    }
}