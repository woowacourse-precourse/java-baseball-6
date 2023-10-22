package view;

import static utils.GameConstant.BALL;
import static utils.GameConstant.GAME_RESTART_OR_QUIT_PROMPT;
import static utils.GameConstant.GAME_START_MESSAGE;
import static utils.GameConstant.GAME_WIN_MESSAGE;
import static utils.GameConstant.NOTHING;
import static utils.GameConstant.STRIKE;

public class OutputView {

    public OutputView() {
    }

    public void write(String message) {
        System.out.println(message);
    }

    public void startGame() {
        write(GAME_START_MESSAGE);
    }

    public void missonClear() {
        write(GAME_WIN_MESSAGE);
        write(GAME_RESTART_OR_QUIT_PROMPT);
    }

    public void hint(int strike, int ball) {
        StringBuilder builder = new StringBuilder();
        if (ball > 0) {
            builder.append(ball).append(BALL);
            if (strike > 0) {
                builder.append(" ");
            }
        }
        if (strike > 0) {
            builder.append(strike).append(STRIKE);
        }
        if (builder.isEmpty()) {
            builder.append(NOTHING);
        }
        write(builder.toString());
    }
}
