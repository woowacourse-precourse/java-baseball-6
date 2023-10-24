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
                    if (inputIntegerArray[i] == answerIntegerArray[j]) {
                        ballHashSet.add(inputIntegerArray[i]);
                        continue;
                    }
                }
            }
        }

        sum = ballHashSet.size();

        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
