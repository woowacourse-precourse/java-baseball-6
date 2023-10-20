package baseball;

import baseball.controller.InputController;
import baseball.entity.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Player player = new Player();
        InputController inputController = new InputController();
        player.setInputString(inputController.playerInput());
        System.out.println(player.getInputString());
    }
}
