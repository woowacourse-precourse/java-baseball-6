package baseball.controller;

import baseball.service.GameLogic;
import baseball.service.InputNumbers;
import baseball.view.PrintMessage;
import baseball.vo.Computer;
import baseball.vo.User;
import java.util.List;

public class BaseBall {

    private Computer computer;

    private User user;

    public void startGame() {
        boolean playGame = true;
        PrintMessage.printGameStart();
        do {
            setComputer();
            playGame = doGame();
        } while (playGame);
    }

    public void setComputer() {
        List<Integer> randomNumbers = GameLogic.generateRandomNumbers();
        computer = new Computer(randomNumbers);
    }

    public void userInput() {
        PrintMessage.requestNumber();
        user = InputNumbers.setInputNumber();
    }

    public boolean doGame() {
        boolean gameEnd = false;
        boolean retry = false;
        do {
            userInput();
            gameEnd = GameLogic.compareResult(computer, user);
        } while (!gameEnd);
        PrintMessage.printRetryGame();
        retry = GameLogic.retryGame();
        return retry;
    }
}
