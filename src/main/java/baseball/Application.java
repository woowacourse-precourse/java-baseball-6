package baseball;

import baseball.application.ConsoleInputOutput;
import baseball.controller.output.Output;
import baseball.domain.game.Game;
import baseball.domain.game.GameOperator;
import baseball.domain.picker.BallPicker;
import baseball.domain.picker.RandomBallPicker;

public class Application {
    private static final BallPicker ballPicker = new RandomBallPicker();
    private static final GameOperator gameOperator = new ConsoleInputOutput();

    public static void main(String[] args) {
        Game game = new Game(ballPicker, gameOperator);

        Output.showStart();

        game.play();
    }
}