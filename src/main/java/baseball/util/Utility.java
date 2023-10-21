package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static List<Integer> assignComputerRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private static List<Integer> string2IntegerArrayList(String userInput) {
        List<Integer> arrayListUserInput = new ArrayList<>();
        String[] splitUserInput = userInput.split("");

        for (String splitWord : splitUserInput) {
            arrayListUserInput.add(Integer.parseInt(splitWord));
        }

        return arrayListUserInput;
    }
}

