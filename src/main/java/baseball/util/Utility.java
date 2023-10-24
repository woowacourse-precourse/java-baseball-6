package baseball.util;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static List<Integer> assignComputerRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static List<Integer> string2IntegerArrayList(String userInput) {
        List<Integer> arrayListUserInput = new ArrayList<>();
        String[] splitUserInput = userInput.split("");

        for (String splitWord : splitUserInput) {
            arrayListUserInput.add(Integer.parseInt(splitWord));
        }

        return arrayListUserInput;
    }

    public static List<Integer> input() {
        String userInput = readLine();

        String targetInput = userInput.trim();

        if (Validation.checkUserInput(targetInput)) {
            return string2IntegerArrayList(targetInput);
        } else {
            throw new IllegalArgumentException();
        }
    }

}

