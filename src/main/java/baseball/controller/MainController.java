package baseball.controller;

import baseball.validator.NumberValidator;
import baseball.view.Input;
import baseball.view.Output;

public class MainController {

    private static int menu;
    private static final int END_MENU = 2;

    private static BaseballController baseballController = new BaseballController();
    private static MainController mainController = new MainController();
    private static NumberValidator numberValidator = new NumberValidator();

    private MainController() {
    }

    public static MainController getMainController() {
        return mainController;
    }

    public void run() {
        Output.printStartMessage();
        do {
            baseballController.playGame();
            Output.printGameEndMessage();
            Output.printRestartMessage();

            String input = Input.getMenu();
            numberValidator.validateMenu(input);
            menu = Integer.parseInt(input);
        } while (menu != END_MENU);
    }
}
