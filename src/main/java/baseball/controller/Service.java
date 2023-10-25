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
    static final int ANSWER_NUMBER = 3;
    static final int NOTHING = 0;
    static final String RESTART_MARK = "1";
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
            if (strike == ANSWER_NUMBER) {
                gameStop = true;
                OutputView.printGameEndMessage(strike);
                askRestartGame(inputView.getUserGameContinue());
            }
            if (strike != ANSWER_NUMBER) {
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
        for (int i = 0; i < ANSWER_NUMBER; i++) {
            if (user.get(i).equals(computer.get(i))) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }

    public void askRestartGame(String input) {
        if (input.equals(RESTART_MARK)) {
            gameStop = false;
            isFirstGame = false;
            gameStart();
        }
    }

    public void scoringGame(int ball, int strike) {
        if (ball == NOTHING && strike == NOTHING) {
            OutputView.printNothingMessage();
        }
        if (ball > NOTHING && strike == NOTHING) {
            OutputView.printBallMessage(ball);
        }
        if (ball == NOTHING && strike > NOTHING) {
            OutputView.printStrikeMessage(strike);
        }
        if (ball > NOTHING && strike > NOTHING) {
            OutputView.printStrikeAndBallMessage(ball, strike);
        }
    }
}