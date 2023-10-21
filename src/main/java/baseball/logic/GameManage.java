package baseball.logic;

import java.util.List;

public class GameManage {

    private int strike;
    private int ball;

    public void init() {
        strike = 0;
        ball = 0;
    }

    public void getResult(List<Integer> answerNumbers, List<Integer> userNumbers) {
        checkStrike(answerNumbers, userNumbers);
        checkBall(answerNumbers, userNumbers);
    }

    private void checkStrike(List<Integer> answerNumbers, List<Integer> userNumbers) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int answer = answerNumbers.get(i);
            int user = userNumbers.get(i);

            if (answer == user) {
                count++;
            }
        }
        strike = count;
    }

    private void checkBall(List<Integer> answerNumbers, List<Integer> userNumbers) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            int answer = answerNumbers.get(i);
            int user = userNumbers.get(i);

            if (answer != user && answerNumbers.contains(user)) {
                count++;
            }
        }

        ball = count;
    }
}
