package baseball.service;

import baseball.domain.Computer;
import baseball.domain.GameRule;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    public static List<Integer> userNumbers;
    public static List<Integer> computerNumbers;

    public static void makeAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GameRule.answerLength) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        Computer.setAnswer(computer);
    }
}
