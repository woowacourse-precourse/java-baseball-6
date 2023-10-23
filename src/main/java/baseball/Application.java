package baseball;

import static baseball.view.Message.startMessage;

import baseball.controller.Baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Baseball baseball = new Baseball();
        startMessage();
        boolean replay = true;
        while (replay) {
            baseball.playGame();
            replay = baseball.replayCheck();
        }
    }
}
