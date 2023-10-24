package baseball.controller;

import baseball.model.BallCount;
import baseball.model.BaseBallGame;
import baseball.util.HintConverter;
import baseball.util.UserInputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BaseBallGame game;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            startGame();
            repeatStage();
            isRunning = inputRestartOption();
        }
    }

    private void startGame() {
        outputView.displayGameStart();
        this.game = BaseBallGame.startGame();
    }

    private void repeatStage() {
        boolean correct = false;
        while (!correct) {
            // 1. 사용자 입력 및 유효성 검사
            int[] input = inputNumbers();
            // 2. 정답 비교
            game.inputAnswer(input);
            BallCount ballCount = game.getCurrentBallCount();
            // 3. 힌트 출력
            String hint = HintConverter.getHint(ballCount.strike(), ballCount.ball());
            outputView.displayHint(hint);
            // 4. 정답이면 게임 종료
            correct = game.isGameWin();
        }
        outputView.displayGameEnd();
    }

    private boolean inputRestartOption() {
        String input = inputView.inputRestartOption();
        return UserInputValidator.validateAndCheckIsRestart(input);
    }

    private int[] inputNumbers() {
        String input = inputView.inputNumbers();
        return UserInputValidator.validateNumbersAndConvertToArray(input);
    }
}
