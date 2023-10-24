package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.run();
    }
}
