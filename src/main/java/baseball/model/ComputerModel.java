package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerModel {
    private static List<Integer> answer;

    public static List<Integer> getUniqueNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static void setAnswer() {
        answer = getUniqueNumbers();
    }

    public static List<Integer> getAnswer() {
        return answer;
    }
}
