package baseball.utils;

import java.util.ArrayList;
import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final ArrayList<Integer> NUMBER_LIST = new ArrayList<>();

    private RandomUtil() {}

    public static ArrayList<Integer> getRandomNumber(int digits, int start, int end){
        while(NUMBER_LIST.size() < digits){
            int randomNum = getRandomBetweenNumber(start, end);

            if(!NUMBER_LIST.contains(randomNum)){
                NUMBER_LIST.add(randomNum);
            }
        }

        return NUMBER_LIST;
    }

    public static int getRandomBetweenNumber(int start, int end){
        return RANDOM.nextInt(end - start + 1) + start;
    }
}
