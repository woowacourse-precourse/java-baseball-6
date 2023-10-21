package baseball;

import java.util.List;

public class Application {



    public static void main(String[] args) {

        BaseBallGame baseBallGame = new BaseBallGame();
        PrintManager printManager = new PrintManager();

        printManager.printGameStart();

        baseBallGame.doBaseBallGame();

    }

}
