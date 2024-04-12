public class User implements Comparable<User>{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return (name + ", возраст " + age + " лет");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return this.getAge() - o.getAge();
    }
}
