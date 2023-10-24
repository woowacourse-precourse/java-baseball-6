package baseball;

import Controller.GameController;
import Player.Computer;
import Player.User;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new User(), new Computer());
        gameController.startGame();
    }
}
