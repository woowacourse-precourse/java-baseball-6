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
        do {
            baseballView.printGameStartMessage();

            User user = new User();
            user.setUserNumber(baseballView.getUserInput());
            user.validateUserInput(user.getUserNumber());

            NumberComparison numberComparison = new NumberComparison();
            game = numberComparison.compareNumber(computer.getRandomNumber(), user.getUserNumber());

            // TODO 볼, 스트라이트 개수 고려 메세지 출력
            baseballView.printResultGameMessage(game.getResultMessage());

            if (game.isSuccess()) {
                baseballView.printWhetherRestartOrExitMessage();
                game.enableGameOver(baseballView.getGameMenu());
            }

        } while(game.isGameOn());

        Console.close();
    }
}
