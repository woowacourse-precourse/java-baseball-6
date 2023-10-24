package baseball.game.controller;

import baseball.game.controller.dto.NumberListDto;
import baseball.game.model.GameModel;
import baseball.game.model.dto.RoundResultDto;
import baseball.game.view.input.InputView;
import baseball.game.view.output.OutputView;


/**
 * 숫자 야구 게임의 흐름을 담당하는 클래스
 */
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
        NumberListDto answer = gameModel.generateRandomAnswer();

        while (true) {
            NumberListDto guess = userInput.getGuessNumbers();
            RoundResultDto roundResult = gameModel.calculateRoundResult(answer, guess);
            userOutput.printResult(roundResult);

            if (roundResult.getStrikeCount() == 3) {
                userOutput.printGameEnd();
                break;
            }
        }

    }
}
