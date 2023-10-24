package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.computer.Computer;
import baseball.model.computer.GameAnswer;
import baseball.model.computer.Score;
import baseball.model.player.GameStateNumber;
import baseball.model.player.GuessNumbers;
import baseball.model.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(
                new Computer(new GameAnswer(), new Score()),
                new Player(new GuessNumbers(), new GameStateNumber()),
                new InputView(),
                new OutputView()
        );
        baseballGameController.start();
    }
}
