package baseball;
import static baseball.Constants.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args){
        GameController baseBallGameController = new GameController();
        baseBallGameController.runGame();
    }
}
