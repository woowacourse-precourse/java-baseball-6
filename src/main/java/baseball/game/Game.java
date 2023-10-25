package baseball.game;

import baseball.utils.Constant;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    public static List<Integer> createAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    String checkAnswer(List<Integer> inputNumbers, List<Integer> answer) {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(inputNumbers.get(i), answer.get(i))) {
                strike += 1;
            } else if (answer.contains(inputNumbers.get(i))) {
                ball += 1;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else if (strike == 0) {
            return ball + "볼";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else {
            return ball + "볼" + " " + strike + "스트라이크";
        }
    }
}