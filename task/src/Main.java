import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, List<User>> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя");
            System.out.flush();
            String name = in.next();
            System.out.println("Введите возраст пользователя");
            System.out.flush();
            int age = in.nextInt();
            User user = new User(name, age);
            if (map.containsKey(age)) {
                List<User> list = map.get(age);
                list.add(user);
                map.put(age, list);
            } else {
                List<User> list = new ArrayList<>();
                list.add(user);
                map.put(age, list);
            }
        }
        System.out.println("Введите требуемый возраст");
        int checkAge = in.nextInt();
        if (map.containsKey(checkAge)) {
            List<User> users = map.get(checkAge);
            Collections.sort(users);
            for (int i = 0; i < users.size(); i++) {
                System.out.println(users.get(i).toString());
            }
        } else {
            System.out.println("Пользователь с возрастом '" + checkAge + "' не найден");
        }
    }
}