package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> getThreeRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static int getStrikeCount(List<Integer> userInput, List<Integer> result) {
        int strikeCount = 0;

        for (int i = 0; i < result.size(); i++) {
            if (userInput.get(i) == result.get(i)) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

    public static int getBallCount(List<Integer> userInput, List<Integer> result) {
        int ballCount = 0;

        for (int i = 0; i < result.size() - 1; i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (userInput.get(i) == result.get(j)) {
                    ballCount++;
                }
            }
        }

        return ballCount;
    }

    public static boolean isNumber(List<Integer> threeNumber) {
        Integer indexZero = threeNumber.get(0);
        Integer indexOne = threeNumber.get(1);
        Integer indexTwo = threeNumber.get(2);

        return (1 <= indexZero && indexZero <= 9)
                && (1 <= indexOne && indexOne <= 9)
                && (1 <= indexTwo && indexTwo <= 9);
    }

    public static boolean isDifferentRandomNumber(List<Integer> threeRandomNumber) {
        Integer indexZero = threeRandomNumber.get(0);
        Integer indexOne = threeRandomNumber.get(1);
        Integer indexTwo = threeRandomNumber.get(2);

        return (indexZero.equals(indexOne))
                && (indexOne.equals(indexTwo))
                && (indexTwo.equals(indexZero));
    }

}
