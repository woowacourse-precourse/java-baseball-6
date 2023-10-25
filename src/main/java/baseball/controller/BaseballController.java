package baseball.controller;

import baseball.service.BaseballService;
import baseball.util.NumberGenerator;
import baseball.view.UserCommunication;
import baseball.domain.GuessResult;

import java.util.List;


public class BaseballController {

    private BaseballService service = new BaseballService();

    public void run() {
        do {
            play();
        } while (!UserCommunication.shouldExit());
    }

    private void play() {
        boolean isCorrect = false;
        List<Integer> answer = NumberGenerator.generateRandomNumber();

        do {
            String userInput = UserCommunication.askForNumber();
            List<Integer> guess = NumberGenerator.stringToIntegerList(userInput);
            GuessResult guessResult = service.countStrikeAndBall(guess, answer);

            if (guessResult.isCorrectAnswer()) {
                UserCommunication.printWinningMessage();
                isCorrect = true;
            } else {
                UserCommunication.printGameStatus(guessResult);
            }

        } while (!isCorrect);
    }

}
