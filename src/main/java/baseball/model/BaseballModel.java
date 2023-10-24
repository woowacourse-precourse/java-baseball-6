package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballModel {
    private static final int ANSWER_MIN_NUMBER = 1;
    private static final int ANSWER_MAX_NUMBER = 9;
    private static final int ANSWER_LENGTH = 3;
    private List<Integer> answer;

    public void generateAnswer() {
        answer = new ArrayList<>();
        while (answer.size() < ANSWER_LENGTH) {
            int randomNum;
            do {
                randomNum = Randoms.pickNumberInRange(ANSWER_MIN_NUMBER, ANSWER_MAX_NUMBER);
            } while (answer.contains(randomNum));
            answer.add(randomNum);
        }
    }

    public Score calculateScore(List<Integer> playerGuess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < answer.size(); i++) {
            int answerNum = answer.get(i);
            if (answerNum == playerGuess.get(i)) {
                strike++;
                continue;
            }
            if (playerGuess.contains(answerNum)) {
                ball++;
            }
        }
        return new Score(strike, ball);
    }
}
