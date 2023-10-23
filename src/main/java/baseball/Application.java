package baseball;

import java.util.Scanner;
import java.util.HashMap;

public class Application {

    public static int ballCount(HashMap<Integer, Integer> ballHashMap) {
        int sum = 0;

        for (int ballHashMapKey : ballHashMap.keySet()) {
            sum += ballHashMap.get(ballHashMapKey);
        }
        
        return sum;
    }

    public static int strikeCount(int[] inputIntegerArray,int[] answerIntegerArray) {
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            if (inputIntegerArray[i] == answerIntegerArray[i]) {
                sum += 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
