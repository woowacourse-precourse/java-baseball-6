package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Init {
    public static void initialize() {
        System.out.println(Text.startingText);

        List<Integer> answer = generateNumber();
    }

    static List<Integer> generateNumber() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < Variables.answerLength){
            int randomInt = Randoms.pickNumberInRange
                    (Variables.randomRangeStart, Variables.randomRangeEnd);
            if (!number.contains(randomInt)) {
                number.add(randomInt);
        }

        return number;
    }
}

