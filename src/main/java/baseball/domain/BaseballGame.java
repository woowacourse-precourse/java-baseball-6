package baseball.domain;

import baseball.domain.player.Batter;
import baseball.domain.player.Pitcher;
import baseball.domain.score.ImmutableBallStrikeCount;
import baseball.dto.BattedBallsDTO;
import baseball.dto.Command;
import baseball.exception.InvalidCommandException;
import baseball.util.InputHandler;
import baseball.util.MessagePrinter;
import java.util.List;

public class BaseballGame {

    public static final int BALL_COUNT = 3;

    private final MessagePrinter messagePrinter;
    private final InputHandler inputHandler;
    private final Pitcher pitcher;
    private final Batter batter;
    private boolean isNewRoundNeeded = true;

    private BaseballGame(Builder builder) {
        this.messagePrinter = builder.messagePrinter;
        this.inputHandler = builder.inputHandler;
        this.pitcher = builder.pitcher;
        this.batter = builder.batter;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void start() {
        messagePrinter.printStartMessage();
        while (isNewRoundNeeded) {
            playNewRound();
        }
    }

    private void playNewRound() {
        Umpire umpire = createUmpire();
        while (true) {
            List<Baseball> battedBalls = getBattedBalls();
            ImmutableBallStrikeCount battedResult = umpire.umpireBattedBalls(battedBalls);
            messagePrinter.printBallAndStrike(battedResult);
            if (battedResult.isAllStrike()) {
                processEndOfRound();
                return;
            }
        }
    }

    private Umpire createUmpire() {
        return Umpire.from(pitcher.pitchBalls());
    }

    private List<Baseball> getBattedBalls() {
        messagePrinter.printBatterRequest();
        BattedBallsDTO battedBallsDTO = inputHandler.getBattedBallsInput();

        return batter.tryBatting(battedBallsDTO);
    }

    private void processEndOfRound() {
        messagePrinter.printEndAndRequestCommand();
        Command command = inputHandler.getCommand();
        checkIsNewRoundNeeded(command);
    }

    private void checkIsNewRoundNeeded(Command command) {
        if (command.orderExit()) {
            isNewRoundNeeded = false;
            return;
        }
        if (!command.orderRestart()) {
            throw new InvalidCommandException();
        }
    }

    public static class Builder {

        private MessagePrinter messagePrinter;
        private InputHandler inputHandler;
        private Pitcher pitcher;
        private Batter batter;

        public Builder messagePrinter(MessagePrinter messagePrinter) {
            this.messagePrinter = messagePrinter;
            return this;
        }

        public Builder inputHandler(InputHandler inputHandler) {
            this.inputHandler = inputHandler;
            return this;
        }

        public Builder pitcher(Pitcher pitcher) {
            this.pitcher = pitcher;
            return this;
        }

        public Builder batter(Batter batter) {
            this.batter = batter;
            return this;
        }

        public BaseballGame build() {
            return new BaseballGame(this);
        }
    }
}
