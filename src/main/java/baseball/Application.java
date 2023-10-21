package baseball;

import baseball.controller.GameManage;
import baseball.model.AgainGameNumber;
import baseball.view.Input;
import baseball.view.Output;

public class Application {
    public static void main(String[] args) {
        Output.gameStartMessage();
        do {
            GameManage gameManage = new GameManage();
            gameManage.gameStart();
        } while (isAgain());
    }

    public static boolean isAgain() {
        AgainGameNumber againGameNumber = new AgainGameNumber(Input.setAgainNumber());
        return againGameNumber.AgainOrNot(againGameNumber.getAgainNumber());
    }
}
