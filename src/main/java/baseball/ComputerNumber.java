package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public static List<Integer> makeUniqueThreeNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    public static String listToString(List<Integer> randomNumbers) {
        String numbers = "";

        for (int i = 0; i < 3; i++) {
            numbers += randomNumbers.get(i).toString();
        }

        return numbers;
    }
}
