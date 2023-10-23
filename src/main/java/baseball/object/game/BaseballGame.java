package baseball.object.game;

import baseball.io.Input;
import baseball.io.Output;
import java.util.Objects;
import java.util.Set;

public class BaseballGame {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MUST_INPUT_RESTARTS_MESSAGE = "1 또는 2를 입력해야 합니다.";

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

            askRestartGame();
        }
    }

    private void askRestartGame() {
        // 게임 또 할건지(재시작 여부 확인)
        Output.consoleLine(GAME_RESTART_MESSAGE);
        String inputRestart = Input.consoleLine();

        if (!INPUT_RESTARTS.contains(inputRestart)) {
            throw new IllegalArgumentException(MUST_INPUT_RESTARTS_MESSAGE);
        }

        if (Objects.equals(inputRestart, GAME_FINISH)) {
            isStart = false;
        }
    }

    private void announceWin() {
        // 3) 맞추기(턴) 종료 멘트 출력
        Output.consoleLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void announceGameStart() {
        // 게임 시작
        Output.consoleLine(GAME_START_MESSAGE);
    }

}
