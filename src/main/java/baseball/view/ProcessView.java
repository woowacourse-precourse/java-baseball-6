package baseball.view;

import static baseball.CONSTANT.BALL_STR;
import static baseball.CONSTANT.INPUT_STR;
import static baseball.CONSTANT.NEXTSTEP_STR;
import static baseball.CONSTANT.NOTHING_STR;
import static baseball.CONSTANT.OUTPUT_STR;
import static baseball.CONSTANT.START_STR;
import static baseball.CONSTANT.STRIKE_STR;

import baseball.dto.GameResultDTO;

public class ProcessView {

    public static void printStart() {
        System.out.println(START_STR);
    }

    public static void printRequireInput() {
        System.out.print(INPUT_STR);
    }

    public static void printResult(GameResultDTO gameResult) {

        if (gameResult.getBall() != 0) {
            System.out.print(gameResult.getBall() + BALL_STR);
        }
        if (gameResult.getStrike() != 0) {
            System.out.print(gameResult.getStrike() + STRIKE_STR);
        }

        if (gameResult.getBall() == 0 && gameResult.getStrike() == 0) {
            System.out.print(NOTHING_STR);
        }
        System.out.println();

        if (gameResult.getSuccess() == true) {
            System.out.println(gameResult.getStrike() + OUTPUT_STR + NEXTSTEP_STR);
        }
    }

}
