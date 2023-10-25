package baseball;

import java.util.List;

public class Referee {
    private List<Integer> answer;
    private final int STRIKE = 2;
    private final int BALL = 1;
    private final int NOTHING = 0;

    public List<Integer> judgePlayerInput(List<Integer> playerInput) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < answer.size(); i++) {
            final int result = judgeNumber(playerInput.get(i), i);

            if (result == BALL) {
                ball += 1;
            }
            if (result == STRIKE) {
                strike += 1;
            }
        }

        return List.of(ball, strike);
    }

    public int judgeNumber(int playerNumber, int index) {
        if (answer.get(index) == playerNumber) {
            return STRIKE;
        }
        if (answer.contains(playerNumber)) {
            return BALL;
        }

        return NOTHING;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    //test를 위한 getter
    public List<Integer> getAnswer() {
        return answer;
    }
}
