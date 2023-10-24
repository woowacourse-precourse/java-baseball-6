package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import baseball.Controller.GameController;
import baseball.model.RestartGame;
import baseball.model.RestartGame;
import baseball.model.UserNum;
import baseball.view.Input;
import baseball.view.Output;

public class Application {
    public static void main(String[] args) {
        Output.initGame();
        do {
            GameController game = new GameController();
            game.start();
        } while (Retry());
    }

    public static boolean Retry() {
        RestartGame restart = new RestartGame(Input.restartGame());
        if (restart.getRestartNumber().equals("1")) {
            return true;
        }
        return false;
    }
}
