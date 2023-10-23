package baseball;

import baseball.controller.GameMaster;

public class Application {

    public static void main(String[] args) {
        GameMaster gm = new GameMaster();
        gm.gameStart();
    }
}
