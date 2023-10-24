package baseball.game.io;

import baseball.game.GameResult;

import static baseball.constant.GameConstant.*;

public class Output {
    public void success() {
        System.out.println(OUTPUT_USER_SUCCESS);
    }
    public void result(GameResult gameResult) {
        if (gameResult.getBall() != 0) {
            System.out.print(gameResult.getBall()+OUTPUT_BALL);
        }
        if (gameResult.getStrike() != 0) {
            System.out.print(gameResult.getStrike() + OUTPUT_STRIKE);
        }
        if (gameResult.getBall() == 0 && gameResult.getStrike() == 0) {
            System.out.print(OUTPUT_NOTING);
        }
        System.out.println();
    }

    public void start() {
        System.out.println(OUTPUT_START_GAME);
    }
}
