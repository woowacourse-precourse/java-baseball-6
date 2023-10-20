package baseball;

import static baseball.GameStatus.START;

public class Application {

    public static void main(String[] args) {
        GameStatus gameStatus = START;
        Output.start();
        while (gameStatus.equals(START)) {
            gameStatus = new Game().start();
        }
    }
}
