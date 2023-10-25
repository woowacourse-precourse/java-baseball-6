package baseball.controller;

import baseball.model.input.RestartOrExitInput;
import baseball.model.numbers.AnswerGenerator;
import baseball.model.numbers.RandomAnswerGenerator;
import baseball.model.numbers.GameNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final AnswerGenerator answerGenerator;
    private boolean isRunning;

    public GameController(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
        this.isRunning = true;
    }

    public void start() {
        OutputView.println(GAME_START_MESSAGE);
        while (isRunning) {
            GameNumbers answer = answerGenerator.generateAnswer();
            BaseballGame baseballGame = new BaseballGame(answer);

            baseballGame.runGame();

            OutputView.println(INPUT_RESTART_OR_EXIT_MESSAGE);
            RestartOrExitInput restartOrExitInput = readInput();
            if (restartOrExitInput.isExitInput()) {
                isRunning = false;
            }
        }
    }

    private RestartOrExitInput readInput() {
        String line = InputView.readLine();
        return new RestartOrExitInput(line);
    }
}
