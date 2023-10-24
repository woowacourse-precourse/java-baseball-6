package baseball;

import baseball.controller.GameController;
import baseball.domain.ComputerBalls;
import baseball.service.GameService;

import java.io.IOException;

public class Application {
    public static void main(String[] args)  {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.play();
    }
}
