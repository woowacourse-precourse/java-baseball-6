package baseball;

import java.util.List;

public class Computer {
    private final int NOTHING = 0;
    private final int BALL = 1;
    private final int STRIKE = 2;

    public List<Integer> countScore(List<Integer> answer, List<Integer> userNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            int score = judgeScore(answer, userNumbers.get(i), i);
            if (score == STRIKE) {
                strike++;
            }
            if (score == BALL) {
                ball++;
            }
        }
        return List.of(ball, strike);
    }

    public int judgeScore(List<Integer> answer, int number, int index) {
        if (answer.get(index) == number) {
            return (STRIKE);
        }
        if (answer.contains(number)) {
            return (BALL);
        }
        return (NOTHING);
    }
}
