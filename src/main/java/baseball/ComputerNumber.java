package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public static List<Integer> makeUniqueThreeNumbers() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static String listToString(List<Integer> computer) {
        String numbers = "";

        for (int i = 0; i < 3; i++) {
            numbers += computer.get(i).toString();
        }

        return numbers;
    }
}
