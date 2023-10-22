package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;
import baseball.util.Parser;
import baseball.view.TextInterface;
import java.util.List;

public class GameController {
    TextInterface textInterface = new TextInterface();
    Parser parser = new Parser();
    Computer computer = new Computer();
    Game game = new Game();
    User user = new User();

    private final int NUMBER_SIZE = 3;
    private final String CONTINUE = "1";
    private final String EXIT = "2";

    public void start() {
        textInterface.openning();
        initGame();
        waitInput();
    }

    public void initGame() {
        game.newGame();
        computer.resetAnswer();
        user.resetAnswer();
        computer.createAnswer(NUMBER_SIZE);
    }

    public void waitInput() {
        String userInput;
        List<Integer> userAnswer;

        userInput = textInterface.readInput();
        if (userInput.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        userAnswer = parser.stringToIntegerList(userInput);
        user.setAnswer(userAnswer);
        calculate();
    }

    public void calculate() {
        Boolean isAnswer;
        int strike;
        int ball;

        List<Integer> userAnswer = user.getAnswer();
        isAnswer = computer.isEqueal(userAnswer);
        if (!isAnswer) {
            find();
            strike = game.getStrike();
            ball = game.getBall();
            textInterface.result(strike, ball);
            game.newGame();
            waitInput();
        }
        if (isAnswer) {
            correct();
        }
    }

    public void correct() {
        String select;

        select = textInterface.correctAnswer();
        System.out.println(select);
        if (select.equals(CONTINUE)) {
            start();
        }
        if (select.equals(EXIT)) {
            textInterface.endGame();
        }
        if (!select.equals(CONTINUE) && !select.equals(EXIT)) {
            throw new IllegalArgumentException();
        }
    }

    public void find() {
        List<Integer> userAnswer = user.getAnswer();
        int temp;

        for (int i = 0; i < NUMBER_SIZE; i++) {
            temp = userAnswer.get(i);
            if (computer.isContain(temp)) {
                if (computer.isSameDigit(i, temp)) {
                    game.increaseStrike();
                } else {
                    game.increaseBall();
                }
            }
        }
    }


}
