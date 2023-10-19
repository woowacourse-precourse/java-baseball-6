package baseball;

import java.util.List;

public class Computer {
    final int NOTHING = 0;
    final int BALL = 1;
    final int STRIKE = 2;
    List<Integer> answer;

    public List<Integer> countScore(List<Integer> userNumbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            int score = judgeScore(userNumbers.get(i), i);
            if (score == STRIKE) {
                strike++;
            }
            if (score == ball) {
                ball++;
            }
        }
        return List.of(ball, strike);
    }

    public int judgeScore(int number, int index) {
        if (answer.get(index) == number) {
            return (STRIKE);
        }
        if (answer.contains(number)) {
            return (BALL);
        }
        return (NOTHING);
    }


}
