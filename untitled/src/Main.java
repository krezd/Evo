import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random rand = new Random();
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        System.out.print("Массив: ");
        for(int i = 0; i < 20;i++){
            array[i] = rand.nextInt(1,16);
            System.out.print(array[i]+ " ");
            if(map.containsKey(array[i])){
                int value = map.get(array[i]);
                map.put(array[i], value+1);
            }
            else{
                map.put(array[i],1);
            }
        }
System.out.println();
        for(Map.Entry<Integer,Integer> pair: map.entrySet()){
            if(pair.getValue() > 1){
                System.out.println("Число '" + pair.getKey() + "' встречается '" + pair.getValue() + "' раз");
            }
        }


    }
}