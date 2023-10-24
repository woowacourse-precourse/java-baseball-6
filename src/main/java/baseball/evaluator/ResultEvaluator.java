package baseball.evaluator;

import baseball.game.Baseball;
import baseball.message.Printer;
import camp.nextstep.edu.missionutils.Console;

public class ResultEvaluator {

    private static final int FULL_CORRECT_COUNT = 3;

    public boolean evaluate(Baseball value) {
        int strike = value.strike();
        int ball = value.ball();

        if (strike == FULL_CORRECT_COUNT) {
            Printer.correct();
            return true;
        } else if (strike == 0 && ball == 0) {
            Printer.nothing();
        } else if (strike != 0 && ball == 0) {
            Printer.strike(strike);
        } else if (strike == 0 && ball != 0) {
            Printer.ball(ball);
        } else {
            Printer.other(ball, strike);
        }

        return false;
    }

    public boolean restart() {
        while (true) {
            Printer.exitOption();
            String input = Console.readLine();
            try {
                int exitOption = Integer.parseInt(input);

                if (exitOption == 1 || exitOption == 2) {
                    return exitOption == 1;
                } else {
                    throw new IllegalArgumentException("잘못된 입력입니다. 1(재시작) 또는 2(종료)를 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요.", e);
            }

        }
    }
}
