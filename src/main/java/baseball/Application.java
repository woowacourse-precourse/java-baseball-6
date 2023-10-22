package baseball;

import baseball.controller.InputController;
import baseball.controller.OutputController;
import baseball.entity.Player;
import static baseball.controller.OutputController.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Player player = new Player();
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();

        outputController.cliOutput(START);
        player.setInputString(inputController.playerInput());
        System.out.println(player.getInputString());
    }
}
