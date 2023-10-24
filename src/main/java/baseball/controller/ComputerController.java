package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerController {

    private static List<Integer> computer;

    private ComputerController() {
    }

    public static synchronized List<Integer> getBaseballNumber() {
        if (computer == null) {
            computer = makeBaseballNumber();
        }
        return computer;
    }

    private static List<Integer> makeBaseballNumber() {
        List<Integer> tempComputer = new ArrayList<>();
        while (tempComputer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!tempComputer.contains(randomNumber)) {
                tempComputer.add(randomNumber);
            }
        }
        return tempComputer;
    }
}
