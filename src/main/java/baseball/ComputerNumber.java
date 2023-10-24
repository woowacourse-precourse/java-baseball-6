package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public static List<Integer> makeUniqueThreeNums() {
        List<Integer> randomNums = new ArrayList<>();

        while (randomNums.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!randomNums.contains(randomNum)) {
                randomNums.add(randomNum);
            }
        }

        return randomNums;
    }

    public static String listToString(List<Integer> randomNums) {
        String numbers = "";

        for (int i = 0; i < 3; i++) {
            numbers += randomNums.get(i).toString();
        }

        return numbers;
    }
}
