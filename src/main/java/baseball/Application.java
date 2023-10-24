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

    public static boolean isNumber(List<Integer> threeNumber) {
        Integer indexZero = threeNumber.get(0);
        Integer indexOne = threeNumber.get(1);
        Integer indexTwo = threeNumber.get(2);

        return (1 <= indexZero && indexZero <= 9)
                && (1 <= indexOne && indexOne <= 9)
                && (1 <= indexTwo && indexTwo <= 9);
    }

}
