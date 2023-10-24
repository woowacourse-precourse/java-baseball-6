package baseball.controller;

import baseball.domain.BallList;
import baseball.utils.BallGenerator;
import baseball.view.BaseballView;

public class BaseballController {

    private BallList baseball;
    private final BallGenerator generator;
    private final BaseballView view;
    private static final int STRIKES_FOR_WIN = 3;
    private static final String ONLY_ONE_OR_TWO = "1 혹은 2만 입력하실 수 있습니다.";

    public BaseballController(BallList baseball, BaseballView view, BallGenerator generator) {
        this.baseball = baseball;
        this.generator = generator;
        this.view = view;
    }

    public void playGame() {
        view.displayStart();
        boolean continueGame = true;
        while (continueGame) {
            BallList userNumber = view.getInput();
            int ballCount = baseball.calculateBall(userNumber);
            int strikeCount = baseball.calculateStrike(userNumber);

            view.displayResult(ballCount, strikeCount);

            if (strikeCount == STRIKES_FOR_WIN) {
                String choice = view.getChoice();
                continueGame = handleChoice(choice);
            }
        }
    }

    private boolean handleChoice(String choice) {
        return switch (choice) {
            case "1" -> {
                resetGame();
                yield true;
            }
            case "2" -> false;
            default -> throw new IllegalArgumentException(ONLY_ONE_OR_TWO);
        };
    }

    private void resetGame() {
        baseball = new BallList(generator.generate());
        view.displayStart();
    }
}