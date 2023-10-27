package baseball.view;

import baseball.util.Constants;
import java.util.List;

public class OutputView {
    public void printGameStart() {
        System.out.println(Constants.START_GAME_MESSAGE);
    }

    public void printGameResult(final List<Integer> result) {
        int strike = result.get(0);
        int ball = result.get(1);

        if (strike == 3) {
            System.out.println("3스트라이크\n"
                    + Constants.CORRECT_NUMBERS_END_GAME_MESSAGE);
            return;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱\n");
            return;
        }

        if (strike > 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }

        if (strike == 0 && ball > 0) {
            System.out.printf("%d볼\n", ball);
            return;
        }

        System.out.printf("%d볼 %d스트라이크\n", ball, strike);
    }
}
