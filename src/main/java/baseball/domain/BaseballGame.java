package baseball.domain;

import baseball.config.AppConfig;
import baseball.dto.BattedBallsDTO;
import baseball.util.InputHandler;
import baseball.util.MessagePrinter;
import java.util.List;

public class BaseballGame {

    public static final int BALL_COUNT = 3;

    private final MessagePrinter messagePrinter;
    private final InputHandler inputHandler;

    private BaseballGame(MessagePrinter messagePrinter, InputHandler inputHandler) {
        this.messagePrinter = messagePrinter;
        this.inputHandler = inputHandler;
    }

    public static BaseballGame of(MessagePrinter messagePrinter, InputHandler inputHandler) {
        return new BaseballGame(messagePrinter, inputHandler);
    }

    public void start() {
        messagePrinter.printStartMessage();
        play();
    }

    private void play() {
        Pitcher pitcher = AppConfig.getPitcher();
        Batter batter = AppConfig.getBatter();
        Umpire umpire = Umpire.from(pitcher.pitchBalls());

        while (true) {
            messagePrinter.printBatterRequest();
            BattedBallsDTO battedBallsDTO = inputHandler.getBattedBallsInput();
            List<Baseball> battedBalls = batter.tryBatting(battedBallsDTO);
        }
    }
}
