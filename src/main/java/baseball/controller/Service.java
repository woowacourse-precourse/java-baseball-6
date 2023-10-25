package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Service {
    Computer computer = new Computer();
    User user = new User();
    InputView inputView = new InputView();
    boolean gameStop = false;
    boolean isFirstGame = true;
    int ball;
    int strike;
    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    public void gameStart() {
        if (isFirstGame) {
            OutputView.printStartingMessage();
        }
        initializeGame();
        while (!gameStop) {
            initializeAskNumbers();
            userNumbers = getUserInput(inputView.getUserGameNumber());
            compareComputerAndUser(userNumbers, computerNumbers);
            if (strike == 3) {
                gameStop = true;
                OutputView.printGameEndMessage(strike);
                askRestartGame(inputView.getUserGameContinue());
            }
            if (strike != 3) {
                scoringGame(ball, strike);
            }
        }
    }

    public void initializeAskNumbers() {
        ball = 0;
        strike = 0;
        OutputView.printInputMessage();
    }

    public void initializeGame() {
        computer.setNumbers();
        computerNumbers = computer.getNumbers();
    }

    public List<Integer> getUserInput(String input) {
        user.setNumbers(input);
        return user.getNumbers();
    }

    public void compareComputerAndUser(List<Integer> user, List<Integer> computer) {
        for (int i = 0; i < 3; i++) {
            if (user.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }

    public void askRestartGame(String input) {
        if (input.equals("1")) {
            gameStop = false;
            isFirstGame = false;
            gameStart();
        }
    }

    public void scoringGame(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            OutputView.printNothingMessage();
        }
        if (ball > 0 && strike == 0) {
            OutputView.printBallMessage(ball);
        }
        if (ball == 0 && strike > 0) {
            OutputView.printStrikeMessage(strike);
        }
        if (ball > 0 && strike > 0) {
            OutputView.printStrikeAndBallMessage(ball, strike);
        }
    }
}