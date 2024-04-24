import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentWithClock implements Learner{
    @Override
    public void learn() {
        System.out.println("Я учусь. .zZ");
        System.out.println("Я закончил учиться");
        Date time = new Date();
        DateFormat str = new SimpleDateFormat("HH:mm:ss");
        System.out.println(str.format(time));
    }
}
