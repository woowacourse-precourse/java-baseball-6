package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        BaseBallGame baseBallGame = new BaseBallGame();
        PrintManager printManager = new PrintManager();
        InputManager inputManager = new InputManager();

        printManager.printGameStart();

        int restart = 0;

        while (restart != 2) {

            baseBallGame.doBaseBallGame();

            printManager.printRestart();
            restart = inputManager.getRestart();
            System.out.println("restart = " + restart);

        }

    }

}
