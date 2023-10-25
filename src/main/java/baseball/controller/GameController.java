package baseball.controller;

import baseball.model.UserAnswer;
import baseball.model.dto.AnswerComparisonResult;
import baseball.utils.GameAnswerManager;

import static baseball.view.GameInputView.inputUserAnswers;
import static baseball.view.GameOutputView.printAnswerComparisonResult;
import static baseball.view.GameOutputView.printGameStartMessage;

public class GameController {

    private final GameAnswerManager gameAnswerManager;

    public GameController(GameAnswerManager gameAnswerManager) {
        this.gameAnswerManager = gameAnswerManager;
    }

    public void start() {
        printGameStartMessage();
        gameAnswerManager.setAnswer();

        boolean isGameEnded = false;
        while (!isGameEnded) {
            UserAnswer userAnswer = new UserAnswer(inputUserAnswers());
            AnswerComparisonResult comparisonResult = userAnswer.compareAnswer(gameAnswerManager);
            printAnswerComparisonResult(
                    comparisonResult.getNumOfBalls(),
                    comparisonResult.getNumOfStrikes()
            );
            isGameEnded = comparisonResult.hasThreeStrikes();
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
