package baseball;

import baseball.controller.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final String RESTART = "1";

    public static void main(String[] args) {
        do{
            new Game(INPUT_VIEW,OUTPUT_VIEW).playOnce();
        }while (INPUT_VIEW.decideRestart().equals(RESTART));
    }
}
