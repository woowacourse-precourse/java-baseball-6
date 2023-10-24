package baseball.evaluator;

import baseball.game.Baseball;
import baseball.message.Printer;
import camp.nextstep.edu.missionutils.Console;


import static baseball.evaluator.MatchResult.CORRECT;
import static baseball.evaluator.MatchResult.NOTHING;
import static baseball.evaluator.MatchResult.ONLY_BALL;
import static baseball.evaluator.MatchResult.ONLY_STRIKE;
import static baseball.evaluator.MatchResult.OTHER;

public class ResultEvaluator {

    private static final int FULL_CORRECT_COUNT = 3;

    public boolean evaluate(Baseball value) {
        int strike = value.strike();
        int ball = value.ball();

        MatchResult result;
        if (strike == FULL_CORRECT_COUNT) {
            result = CORRECT;
        } else if (strike == 0 && ball == 0) {
            result = NOTHING;
        } else if (strike != 0 && ball == 0) {
            result = ONLY_STRIKE;
        } else if (strike == 0 && ball != 0) {
            result = ONLY_BALL;
        } else {
            result = OTHER;
        }

        switch (result) {
            case CORRECT -> {
                Printer.correct();
                return true;
            }
            case NOTHING -> Printer.nothing();
            case ONLY_STRIKE -> Printer.strike(strike);
            case ONLY_BALL -> Printer.ball(ball);
            case OTHER -> Printer.other(ball, strike);
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
