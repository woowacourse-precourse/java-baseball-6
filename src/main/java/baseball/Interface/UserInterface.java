package baseball.Interface;

import baseball.game.BaseballGame;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    private final BaseballGame baseballGame;

    public UserInterface(Scanner scanner, BaseballGame baseballGame) {
        this.scanner = scanner;
        this.baseballGame = baseballGame;
    }
}
