package baseball.domain;

import static baseball.global.constant.BaseballConstant.PLAY_AMOUNT;
import static baseball.global.constant.BaseballConstant.SIGN_RESTART;
import static baseball.global.constant.BaseballConstant.SIGN_STOP;
import static baseball.global.constant.BaseballConstant.THREE_STRIKE;

import baseball.ui.InputView;
import baseball.ui.OutputView;

public class BaseballGame {
    private final OutputView outputView;
    private final InputView inputView;

    private static Computer computer;

    public BaseballGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        printStartMessage();
        computer = Computer.generate();

        playGame();
    }

    private void playGame() {
        GameResult result = play();

        if (result.getStrikeCount() == THREE_STRIKE) {
            outputView.printGameFinishMessage();
            String option = inputView.readRestartOrNot();
            if (option.equals(SIGN_RESTART)) {
                computer = Computer.generate();
                playGame();
            } else if (option.equals(SIGN_STOP)) {
                return;
            }
        } else {
            outputView.printGameResultMessage(result);
            playGame();
        }
    }

    private GameResult play() {
        Player player = Player.from(inputView.readPlayerNumber());
        GameResult result = new GameResult();

        for (int idx = 0; idx < PLAY_AMOUNT; idx++) {
            int playerNumber = player.getNumberOf(idx);
            int computerNumber = computer.getNumberOf(idx);

            result.update(playerNumber, computerNumber, computer);
        }

        return result;
    }

    private void printStartMessage() {
        outputView.printGameStartMessage();
    }
}
