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
    private static Player player;

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
        while (true) {
            player = new Player(inputView.readPlayerNumber());
            GameResult result = play(computer, player);

            if (result.getStrikeCount() == THREE_STRIKE) {
                outputView.printGameFinishMessage();
                String option = inputView.readRestartOrNot();
                if (option.equals(SIGN_RESTART)) {
                    computer = Computer.generate();
                    continue;
                } else if (option.equals(SIGN_STOP)) {
                    break;
                }
            }
            outputView.printGameResultMessage(result);
        }
    }

    private GameResult play(Computer computer, Player player) {
        GameResult result = new GameResult();

        for (int idx = 0; idx < PLAY_AMOUNT; idx++) {
            int playerNumber = player.getNumberOf(idx);
            int computerNumber = computer.getNumberOf(idx);

            if (playerNumber == computerNumber) {
                result.addStrikeCount();
                continue;
            }
            if (computer.contains(playerNumber)) {
                result.addBallCount();
            }
        }

        return result;
    }

    private void printStartMessage() {
        outputView.printGameStartMessage();
    }
}
