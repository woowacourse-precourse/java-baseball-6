package baseball.game;

import baseball.io.Input;
import baseball.io.Output;
import java.util.Objects;
import java.util.Set;

public class BaseballGame {

    // TODO : 과도한 상수 사용 -> enum으로 교체 (메시지는 특히나)
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MUST_INPUT_RESTARTS_MESSAGE = "1 또는 2를 입력해야 합니다.";

    public static final String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART = "1";
    private static final String GAME_FINISH = "2";
    private static final Set<String> INPUT_RESTARTS = Set.of(GAME_RESTART, GAME_FINISH);

    private boolean isStart = true;

    public void play() {
        announceGameStart();

        while (isStart) {
            Turn turn = new Turn();
            turn.play();

            announceWin();
            askRestart();
        }
    }

    private void announceGameStart() {
        Output.consoleLine(GAME_START_MESSAGE);
    }

    private void announceWin() {
        Output.consoleLine(GAME_WIN_MESSAGE);
    }

    // TODO : 과도한 상수 사용 -> enum으로 교체
    // TODO : Input.consoleLine() -> consoleNumber()로 교체
    private void askRestart() {
        Output.consoleLine(GAME_RESTART_MESSAGE);
        String inputRestart = Input.consoleLine();

        if (!INPUT_RESTARTS.contains(inputRestart)) {
            throw new IllegalArgumentException(MUST_INPUT_RESTARTS_MESSAGE);
        }

        if (Objects.equals(inputRestart, GAME_FINISH)) {
            isStart = false;
        }
    }

}
