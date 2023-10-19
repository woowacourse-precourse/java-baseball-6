package baseball;

import java.util.List;

public class Computer {
    final int NOTHING = 0;
    final int BALL = 1;
    final int STRIKE = 2;

    int judgeScore(List<Integer> answer, int number, int index) {
        if (answer.get(index) == number) {
            return (STRIKE);
        }
        if (answer.contains(number)) {
            return (BALL);
        }
        return (NOTHING);
    }
}
