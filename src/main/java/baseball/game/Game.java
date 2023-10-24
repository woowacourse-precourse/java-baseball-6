package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Objects;

public class Game {
    List<Integer> createAnswer() {
        List<Integer> randNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        randNumbers.forEach(System.out::println);
        return randNumbers;
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