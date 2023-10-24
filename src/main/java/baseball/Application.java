package baseball;

import baseball.controller.Baseball;

public class Application {
    public static void main(String[] args) {
        Baseball baseball = new Baseball();
        baseball.startGame();
        baseball.playGame();
    }
}
