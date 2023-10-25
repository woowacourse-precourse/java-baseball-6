package baseball;

import baseball.game.GameService;
import baseball.input.InputFactory;

import static baseball.input.InputFactory.ConsoleType.*;


public class Application {
    private static final GameService gameService = GameService.getInstance();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputFactory.setConsoleType(SCANNER);
        gameService.startGame();
        InputFactory.close();
    }
}
