package baseball;

import java.util.HashSet;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static int ballCount(int[] inputIntegerArray, int[] answerIntegerArray) {
        int sum = 0;

        HashSet<Integer> ballHashSet = new HashSet<>(3);


        for (int i = 0; i < answerIntegerArray.length; i++) {
            if (inputIntegerArray[i] == answerIntegerArray[i]) {
                continue;
            }
            else {
                for (int j = 0; j < answerIntegerArray.length; j++) {
                    if ((inputIntegerArray[i] == answerIntegerArray[j]) && (i != j)) {
                        ballHashSet.add(inputIntegerArray[i]);
                        continue;
                    }
                }
            }
        }

        sum = ballHashSet.size();

        return sum;
    }

    public static int strikeCount(int[] inputIntegerArray,int[] answerIntegerArray) {
        int sum = 0;

        for (int i = 0; i < answerIntegerArray.length; i++) {
            if (inputIntegerArray[i] == answerIntegerArray[i]) {
                sum += 1;
            }
        }

        return sum;
    }

    public static int[] inputParsingToIntArray(String input) {
        int[] intArray = new int[input.length()];

        for(int i = 0; i < input.length(); i++){
            intArray[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        return intArray;
    }

    public static boolean inputValidator(String input) {
        boolean result = true;
        int[] intArray = new int[3];
        HashSet<Integer> intArrayHashSet = new HashSet<>(3);

        if (input.length() != 3) {
            result = false;
        }

        try {
            intArray = inputParsingToIntArray(input);
        }
        catch (NumberFormatException event) {
            result = false;
        }

        for (int i = 0; i < intArray.length; i++) {
            intArrayHashSet.add(intArray[i]);
        }

        if (intArrayHashSet.size() != 3) {
            result = false;
        }

        return result;
    }



    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
