import java.util.stream.LongStream;

public class Main {

    public static long getArithmeticProgressionSum(long a, long b){

        return LongStream.range(a,b).sum();
    }

    public static void main(String[] args) {
        System.out.println( getArithmeticProgressionSum(10000000,1000000000));
    }
}