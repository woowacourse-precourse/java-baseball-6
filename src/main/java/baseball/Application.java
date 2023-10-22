package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    private static void pickComputerNumber(List<Integer> computerNumber) {
        int randomNumber;
        while (computerNumber.size() < 3) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }
    }
}
