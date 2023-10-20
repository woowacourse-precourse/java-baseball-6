package baseball.game;

import static baseball.converter.AfterBaseballStateConverter.stringToAfterBaseballState;
import static baseball.converter.BaseballStateConverter.stringToBaseballState;

import baseball.state.AfterBaseballState;
import baseball.state.BaseballResult;
import baseball.state.BaseballState;
import baseball.utils.IoHelper;
import baseball.utils.RandomGenerator;
import java.util.List;

public class BaseballGame implements Game {
    BaseballState computer;

    public void awake() {
        IoHelper.println("숫자 야구 게임을 시작합니다.");
    }

    public void beforeLoop() {
        final List<Integer> randoms = RandomGenerator.generateUniqueRandomListOf(3);

        computer = new BaseballState(randoms);
    }

    public void gameLoop() {
        final String input = IoHelper.promptColon("숫자를 입력해주세요");
        final BaseballState userGuess = stringToBaseballState(input);
        final BaseballResult result = computer.diff(userGuess);

        IoHelper.println(result.toString());
        if (result.isGameEnd()) {
            IoHelper.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            GameManager.notifyEndGame();
        }
    }

    public void afterLoop() {
        final String input = IoHelper.promptln("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        final AfterBaseballState afterState = stringToAfterBaseballState(input);

        if (afterState == AfterBaseballState.END_GAME) {
            GameManager.notifyEndGameManager();
        }
    }

    public void cleanup() {
    }
}
