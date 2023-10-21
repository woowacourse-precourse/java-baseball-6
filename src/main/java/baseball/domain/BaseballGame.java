package baseball.domain;

import baseball.config.AppConfig;
import baseball.util.MessagePrinter;

public class BaseballGame {

    public static final int BALL_COUNT = 3;

    private final MessagePrinter messagePrinter;

    private BaseballGame(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public static BaseballGame from(MessagePrinter messagePrinter) {
        return new BaseballGame(messagePrinter);
    }

    public void start() {
        messagePrinter.printStartMessage();
        play();
    }

    private void play() {
        Pitcher pitcher = AppConfig.getPitcher();
        Umpire umpire = Umpire.from(pitcher.pitchBalls());
    }
}
