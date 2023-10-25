package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public static String computerNumber;

    public static String getComputerNumber() {
        getRandomNumber();
        return computerNumber;
    }

    public static String getRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computerNumber = toString(computer);
    }

    private static String toString(List<Integer> computerNumberList) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : computerNumberList) {
            sb.append(number);
        }
        return sb.toString();
    }
}
