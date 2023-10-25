package baseball;

import baseball.controller.Baseball;

public class Application {
    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        Baseball baseball = new Baseball();

        baseball.playGame(NUMBER_LENGTH);
    }
}
