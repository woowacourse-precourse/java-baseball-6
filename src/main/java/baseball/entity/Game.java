package baseball.entity;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {
    private String answer;
    private boolean finished;

    public Game() {
        initAnswer();
        finished = false;
    }

    private void initAnswer() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        this.answer = "";
        for (Integer integer : integers) {
            this.answer += integer.toString();
        }
    }

    private int countStrike(String inputString) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (inputString.charAt(i) == this.answer.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }

    private int countBall(String inputString) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (inputString.charAt(i) != this.answer.charAt(i) && this.answer.contains(String.valueOf(inputString.charAt(i)))) { //리팩토링 필요한 지점
                count += 1;
            }
        }
        return count;
    }

    private boolean isAnswer(String inputString) {
        if (countStrike(inputString) == 3) {
            return true;
        }
        return false;
    }
}
