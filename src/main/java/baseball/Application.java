package baseball;
import baseball.Common.Messages;
import baseball.Controller.GameController;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        GameController.getInstance().run();
    }
}
