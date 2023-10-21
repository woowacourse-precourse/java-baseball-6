package baseball.controller;

import static baseball.domain.BaseballNumberConstants.BASEBALL_NUMBER_LEN;

import baseball.domain.BaseballNumber;
import baseball.domain.GameResultDTO;
import baseball.domain.PlayerChoice;
import baseball.domain.RandomBaseballNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private BaseballNumber computerBaseballNumber;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGameStart();
        playGame();
    }

    void playGame() {
        PlayerChoice playerChoice = PlayerChoice.RETRY;
        while (playerChoice == PlayerChoice.RETRY) {
            initComputerBaseballNumber();
            playOneGame();
            outputView.printGameFinish();
            playerChoice = askRetry();
        }
    }

    private void initComputerBaseballNumber() {
        computerBaseballNumber = new RandomBaseballNumberGenerator().generate();
    }

    private void playOneGame() {
        BaseballNumber playerBaseballNumber;
        GameResultDTO gameResultDTO;
        do {
            playerBaseballNumber = new BaseballNumber(inputView.readPlayerNumbers());
            gameResultDTO = computerBaseballNumber.calculationGameResult(playerBaseballNumber);
            outputView.printGameResult(gameResultDTO);
        } while (!isFinish(gameResultDTO));
    }

    private boolean isFinish(GameResultDTO gameResultDTO) {
        return gameResultDTO.getStrike() == BASEBALL_NUMBER_LEN;
    }

    private PlayerChoice askRetry() {
        return PlayerChoice.from(inputView.readPlayerChoice());
    }
}
