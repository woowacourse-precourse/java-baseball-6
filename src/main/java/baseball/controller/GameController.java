package baseball.controller;

import baseball.domain.Game;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.view.InputView.readUserAnswer;

public class GameController {
    public void playGame() {
        Game game = new Game();
    }

    public List<Integer> askAnswer() {
        String userAnswer = readUserAnswer();
        validateUserAnswer(userAnswer);
        return userAnswerToUserNumbers(userAnswer);
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
