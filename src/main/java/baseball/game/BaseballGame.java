package baseball.game;

import baseball.game.message.BaseballGameMessage;
import baseball.io.Input;
import baseball.io.Output;
import java.util.Objects;
import java.util.Set;

public class BaseballGame {

    // TODO : 과도한 상수 사용 -> enum으로 교체 (메시지는 특히나)
    private static final Integer GAME_RESTART = 1;
    private static final Integer GAME_FINISH = 2;
    private static final Set<Integer> INPUT_RESTARTS = Set.of(GAME_RESTART, GAME_FINISH);

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
        Output.consoleLine(BaseballGameMessage.GAME_START_MESSAGE.get());
    }

    private void announceWin() {
        Output.consoleLine(BaseballGameMessage.GAME_WIN_MESSAGE.get());
    }

    // TODO : 과도한 상수 사용 -> enum으로 교체
    private void askRestart() {
        Output.consoleLine(BaseballGameMessage.GAME_RESTART_MESSAGE.get());
        Integer inputRestart = Input.consoleNumber();

        if (!INPUT_RESTARTS.contains(inputRestart)) {
            throw new IllegalArgumentException(BaseballGameMessage.MUST_INPUT_RESTARTS_MESSAGE.get());
        }

        if (Objects.equals(inputRestart, GAME_FINISH)) {
            isStart = false;
        }
    }

}
