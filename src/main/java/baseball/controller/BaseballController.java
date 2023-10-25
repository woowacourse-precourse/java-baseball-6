package baseball.controller;

import baseball.service.BaseballService;
import baseball.util.BaseballUtil;
import baseball.view.UserInterface;
import baseball.vo.GuessResultVO;

import java.util.List;


public class BaseballController {

    private BaseballService service = new BaseballService();

    public void run() {
        do {
            play();
        } while (!UserInterface.shouldExit());
    }

    private void play() {
        boolean isCorrect = false;
        List<Integer> answer = BaseballUtil.generateRandomNumber();

        do {
            String userInput = UserInterface.askForNumber();
            List<Integer> guess = BaseballUtil.stringToIntegerList(userInput);
            GuessResultVO guessResult = service.countStrikeAndBall(guess, answer);

            if (guessResult.isCorrectAnswer()) {
                UserInterface.printWinningMessage();
                isCorrect = true;
            } else {
                UserInterface.printGameStatus(guessResult);
            }

        } while (!isCorrect);
    }

}
