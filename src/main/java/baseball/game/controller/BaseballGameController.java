package baseball.game.controller;

import baseball.game.model.GameModel;
import baseball.game.model.dto.RoundResult;
import baseball.game.view.input.InputView;
import baseball.game.view.output.OutputView;
import java.util.List;

public class BaseballGameController {

    private final InputView userInput;
    private final OutputView userOutput;
    private final GameModel gameModel;

    public BaseballGameController(InputView userInput, OutputView userOutput, GameModel gameModel) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.gameModel = gameModel;
    }

    public void baseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isContinue;
        do {
            startRound();
            isContinue = userInput.askForGameContinue();
        } while (isContinue);
    }

    private void startRound() {
        List<Integer> answerNumbers = gameModel.generateRandomAnswer();

        while (true) {
            List<Integer> guessNumbers = userInput.getGuessNumbers();
            RoundResult roundResult = gameModel.calculateRoundResult(answerNumbers, guessNumbers);
            userOutput.printResult(roundResult);

            if (roundResult.getStrikeCount() == 3) {
                userOutput.printGameEnd();
                break;
            }
        }

    }
}
