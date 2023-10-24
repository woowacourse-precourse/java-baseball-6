package baseball.game;

import camp.nextstep.edu.missionutils.Console;


public class UserController {
    Game game;
    Printer printer;
    Validator validator;
    Config config;

    public void run() {
        printer.printStartMessage();
        Integer option = config.getPlayOption();
        while (continueGame(option)) {
            game.playGame();
            printer.printReplayMessage();
            option = Integer.parseInt(Console.readLine());
            validator.validateReplayOption(option);
        }
    }

    public UserController(Game game) {
        this.game = game;
        this.printer = game.getPrinter();
        this.validator = game.getValidator();
        this.config = game.getConfig();
    }
    Boolean continueGame(Integer option) {
        return option.equals(config.getPlayOption());
    }
}
