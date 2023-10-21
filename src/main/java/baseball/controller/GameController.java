package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.GameResult;
import baseball.model.UserNumber;
import baseball.service.NumberMatcher;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private AnswerNumber answerNumber;
    private NumberMatcher numberMatcher;
    private InputView inputView;
    private OutputView outputView;

    public GameController(NumberMatcher numberMatcher, InputView inputView, OutputView outputView) {
        this.numberMatcher = numberMatcher;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        outputView.displayStartGame();

        do {
            initializeAnswerNumber();
            playRound();
        } while (isContinued());
    }

    private void playRound() {
        while (true) {
            String userInput = inputView.requestUserNumber();
            UserNumber userNumber = new UserNumber(userInput);

            GameResult result = numberMatcher.match(userNumber.getUserNumber(),
                answerNumber.getAnswerNumber());

            outputView.displayResult(result.getBallCount(), result.getStrikeCount());

            if (result.isSuccess()) {
                outputView.displayWinningMessage();
                break;
            }

        }
    }

    private void initializeAnswerNumber() {
        this.answerNumber = new AnswerNumber();
    }

    private boolean isContinued() {
        int choice = inputView.requestGameRestart();
        return choice == 1;
    }


}
