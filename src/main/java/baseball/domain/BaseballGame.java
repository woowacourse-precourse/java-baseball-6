package baseball.domain;

import baseball.config.AppConfig;
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
    private boolean isNewRoundNeeded;

    private BaseballGame(MessagePrinter messagePrinter, InputHandler inputHandler) {
        this.messagePrinter = messagePrinter;
        this.inputHandler = inputHandler;
        this.isNewRoundNeeded = true;
    }

    public static BaseballGame of(MessagePrinter messagePrinter, InputHandler inputHandler) {
        return new BaseballGame(messagePrinter, inputHandler);
    }

    public void start() {
        messagePrinter.printStartMessage();
        while (isNewRoundNeeded) {
            playNewRound();
        }
    }

    private void playNewRound() {
        Pitcher pitcher = AppConfig.getPitcher();
        Batter batter = AppConfig.getBatter();
        Umpire umpire = Umpire.from(pitcher.pitchBalls());

        while (true) {
            messagePrinter.printBatterRequest();
            BattedBallsDTO battedBallsDTO = inputHandler.getBattedBallsInput();
            List<Baseball> battedBalls = batter.tryBatting(battedBallsDTO);
            ImmutableBallStrikeCount battedResult = umpire.umpireBattedBalls(battedBalls);
            messagePrinter.printBallAndStrike(battedResult);
            if (isRoundEnd(battedResult)) {
                return;
            }
        }
    }

    private boolean isRoundEnd(ImmutableBallStrikeCount battedResult) {
        if (!battedResult.isAllStrike()) {
            return false;
        }
        messagePrinter.printEndAndRequestCommand();
        Command command = inputHandler.getCommand();
        checkIsNewRoundNeeded(command);
        return true;
    }

    private void checkIsNewRoundNeeded(Command command) {
        if (command.orderRestart()) {
            isNewRoundNeeded = false;
            return;
        }
        if (!command.orderExit()) {
            throw new InvalidCommandException();
        }
    }
}
