package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.GameResult;
import baseball.model.UserInputNumber;
import baseball.service.NumberMatcher;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private static final int RESTART = 1;

    private final NumberMatcher numberMatcher;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(NumberMatcher numberMatcher, InputView inputView, OutputView outputView) {
        this.numberMatcher = numberMatcher;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        outputView.displayStartGame();
        do {
            playRound();
        } while (isContinued());
    }

    private void playRound() {
        AnswerNumber answerNumber = new AnswerNumber();
        while (true) {
            String userInput = inputView.requestUserNumber();
            UserInputNumber userInputNumber = new UserInputNumber(userInput);

            GameResult result = numberMatcher.match(userInputNumber.userNumberToList(),
                answerNumber.answerNumberToList());

            outputView.displayResult(result.getBallCount(), result.getStrikeCount());

            if (result.isSuccess()) {
                outputView.displayWinningMessage();
                break;
            }

        }
    }


    private boolean isContinued() {
        int choice = inputView.requestGameRestart();
        return choice == RESTART;
    }

}
