package baseball;

import baseball.view.ProcessView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        ProcessView.printStart();
        Game game = new Game();

        while (game.startGame()) {

        }

    }
}
