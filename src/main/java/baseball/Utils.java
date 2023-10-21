package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Stream;

public class Utils {

    public static void getRandomNumber(List<Integer> computerNumber) {
        computerNumber.clear();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static int[] convertStringToInt(String input) {
        return Stream.of(input.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
