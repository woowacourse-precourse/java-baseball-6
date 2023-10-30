package baseball.controller;

import baseball.domain.BallNumbers;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BallNumbers ballNumbers;

    public BaseballController(InputView inputView, OutputView outputView,
                              BallNumbers ballNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ballNumbers = ballNumbers;
    }

    public void start() {
        outputView.printGameStart();

        String inputStartNewGame;

        // 사용자가 2를 입력할 때까지 게임 반복
        do {
            tryGame();
            inputStartNewGame = inputView.inputStartNewGame();
            InputValidator.validateInputStartNewGame(inputStartNewGame);

        } while (InputView.START_NEW_GAME_NUMBER.equals(inputStartNewGame));
    }

    private void tryGame() {
        int strike = 0;

        List<Integer> correctNumber = ballNumbers.generateBaseball();

        // 3스트라이크가 될 때까지 숫자 입력 반복
        do {
            List<Integer> inputNumbers = inputView.inputNumbers();
            InputValidator.validateNumberDuplication(inputNumbers);

            List<Integer> result = ballNumbers.compareNumbers(inputNumbers);
            strike = result.get(0);

            outputView.printGameResult(result);

        } while (strike < 3);
    }
}
