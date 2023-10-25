package baseball.entity;

import baseball.controller.BaseballGame;
import baseball.dto.Score;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameComputer {

    private final List<Integer> answer;

    public BaseballGameComputer() {
        answer = generateAnswer();
    }

    private List<Integer> generateAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Score scoring(String guess) {
        int strike = 0, ball = 0;
        for (int i=0; i < guess.length(); i++) {
            for (int j=0; j < guess.length(); j++) {
                if (answer.get(i) == guess.charAt(j) - '0') {
                    if (i == j) {
                        strike++;
                    } else {
                        ball++;
                    }
                }
            }
        }
        return new Score(strike, ball);
    }

    public boolean isClear(Score score) {
        boolean result = false;
        if (score.getStrike() == 3) {
            result = true;
        }
        return result;
    }

}
