package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Com {
    public static List<Integer> answerNumbers;

    public static void setAnswerNumbers() {
        answerNumbers = generateRandomUnique3Numbers();
    }

    public static List<Integer> generateRandomUnique3Numbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number))
                numbers.add(number);
        }
        return numbers;
    }



}
