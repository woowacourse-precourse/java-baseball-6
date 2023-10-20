package baseball;

import baseball.io.Input;
import baseball.io.Output;
import java.util.Objects;
import java.util.Set;

public class BaseballGameTransaction {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String GAME_RESTART = "1";
    private static final String GAME_FINISH = "2";
    private static final Set<String> INPUT_RESTARTS = Set.of(GAME_RESTART, GAME_FINISH);

    public void run() {
        Output.consoleLine(GAME_START_MESSAGE);

        boolean whetherPlay = true;
        while (whetherPlay) {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();

            Output.consoleLine(GAME_RESTART_MESSAGE);
            String inputRestart = Input.consoleLine();

            if (!INPUT_RESTARTS.contains(inputRestart)) {
                throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
            }

            if (Objects.equals(inputRestart, GAME_FINISH)) {
                whetherPlay = false;
            }
        }
    }

}
