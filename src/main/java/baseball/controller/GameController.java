package baseball.controller;

import baseball.domain.Game;
import baseball.domain.GameResult;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.service.NumberGenerator.pickNumbersInRangeWithoutDuplicates;
import static baseball.view.InputView.readUserAnswer;
import static baseball.view.OutputView.printGameResult;

public class GameController {
    public void play() {
        boolean isContinue = true;

        while (isContinue) {
            playGame();
            isContinue = askContinue();
        }
    }

    private boolean askContinue() {
        return false;
    }

    public void playGame() {
        Game game = new Game(pickNumbersInRangeWithoutDuplicates(1, 9, 3));
        askUntilCorrectAnswer(game);
    }

    public List<Integer> askAnswer() {
        String userAnswer = readUserAnswer();
        validateUserAnswer(userAnswer);
        return userAnswerToUserNumbers(userAnswer);
    }

    public void askUntilCorrectAnswer(Game game) {
        while (!game.isUserWin()) {
            List<Integer> userNumbers = askAnswer();
            GameResult gameResult = game.makeGameResult(userNumbers);
            printGameResult(gameResult);
        }
    }

    private void validateUserAnswer(String userAnswer) {
    }

    private List<Integer> userAnswerToUserNumbers(String userInput) {
        return userInput.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
