package baseball;

import baseball.controller.BullsAndCowsController;

public class Application {

    private static final BullsAndCowsController bullsAndCowsController = new BullsAndCowsController();

    public static void main(String[] args) {

        bullsAndCowsController.BullsAndCowsGame();
    }
}
