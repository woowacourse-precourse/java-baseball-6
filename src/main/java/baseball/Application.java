package baseball;

import baseball.controllers.GameController;
import baseball.models.RegameNumber;
import baseball.views.InputView;
import baseball.views.OutputView;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStart();
        do {
            GameController baseballGame = new GameController();
            baseballGame.start();
        } while (askRegame());
    }

    public static boolean askRegame() {
        RegameNumber regameNumber = new RegameNumber(InputView.setRegameNumber());
        if (regameNumber.getRegameNumber().equals("1")) {
            return true;
        }
        return false;
    }

}
