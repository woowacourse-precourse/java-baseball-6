package baseball.controller;

import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.User;
import baseball.util.NumberComparison;
import baseball.view.BaseballView;
import camp.nextstep.edu.missionutils.Console;


public class BaseballController {

    private Computer computer;
    private User user;
    private BaseballView baseballView;
    private Game game;

    public BaseballController() {
        computer = new Computer();
        baseballView = new BaseballView();
        user = new User();
        game = new Game();
    }

    public void start() {
        baseballView.printGameStartMessage();

        do {
            User user = new User();
            user.setUserNumber(baseballView.getUserInput());
            user.validateUserInput(user.getUserNumber());

            NumberComparison numberComparison = new NumberComparison();
            game = numberComparison.compareNumber(computer.getRandomNumber(), user.getUserNumber());

            baseballView.printResultGameMessage(game.getBallCount(), game.getStrikeCount());

            if (game.isSuccess()) {
                baseballView.printWhetherRestartOrExitMessage();
                game.controlGameMenu(baseballView.getGameMenu());
            }

            if (game.isGameRestart()) {
                game = new Game();
                computer = new Computer();
            }

        } while(game.isGameOn());
    }
}
