package baseball;

import static baseball.GameStatus.START;

public class Application {

    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        GameStatus gameStatus = START;
        baseball.printStartMessage();
        while (gameStatus.equals(START)) {
            gameStatus = baseball.run();
        }
    }
}
