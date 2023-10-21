package baseball.trasaction;

import baseball.object.game.BaseballGame;
import baseball.io.Input;
import baseball.io.Output;
import java.util.Objects;
import java.util.Set;

public class BaseballGameTransaction {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MUST_INPUT_RESTARTS_MESSAGE = "1 또는 2를 입력해야 합니다.";

    private static final String GAME_RESTART = "1";
    private static final String GAME_FINISH = "2";
    private static final Set<String> INPUT_RESTARTS = Set.of(GAME_RESTART, GAME_FINISH);

    public void run() {
        try {
            playSession();
        } catch (IllegalArgumentException e) {
            Output.consoleLine("예외가 발생하여 어플리케이션을 종료합니다.");
            throw e;
        }
    }

    private static void playSession() {
        Output.consoleLine(GAME_START_MESSAGE);

        boolean whetherPlay = true;
        while (whetherPlay) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();

            Output.consoleLine(GAME_RESTART_MESSAGE);
            String inputRestart = Input.consoleLine();

            if (!INPUT_RESTARTS.contains(inputRestart)) {
                throw new IllegalArgumentException(MUST_INPUT_RESTARTS_MESSAGE);
            }

            if (Objects.equals(inputRestart, GAME_FINISH)) {
                whetherPlay = false;
            }
        }
    }

}
