package refactor.controller;

import refactor.domain.Computer;
import refactor.domain.Game;
import refactor.domain.User;
import refactor.dto.Score;
import refactor.view.InputValue;
import refactor.view.OutputValue;

public class GameController {

    private Computer computer = new Computer();
    private User user = new User();
    private Game game = new Game();

    private InputValue inputValue = new InputValue();
    private OutputValue outputValue = new OutputValue();

    private boolean status = true;

    public void gameStart() {

        init();

        while(status) {

            input();

            calculator();

            restart();
        }

    }

    private void init() {

        outputValue.startMessage();

        computer.randomNumberGenerator();
    }

    private void input() {

        String input = inputValue.inputAnswer();

        user.userNumberGenerator(input);
    }

    private void calculator() {

        game.resetScore();

        game.calculateScore(computer.getNumber(), user.getNumber());

        Score score = game.getScore();

        outputValue.resultMessage(score);
    }

    private void restart() {

        if(!game.threeStrikeCheck()){
            return;
        }

        if(!inputValue.restartCheck()){
            status = false;
            return;
        }

        init();

    }

}
