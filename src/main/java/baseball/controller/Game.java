package baseball.controller;

import baseball.domain.Numbers;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private static final int THREE_STRIKE = 3;

    private final InputView inputView;
    private final OutputView outputView;
    private final Numbers computerNumbers;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        computerNumbers = new Numbers();
    }

    public void playOnce() {
        outputView.printGameStartMessage();
        getGameResult();
        outputView.printFinishMessage();
    }

    public void getGameResult() {
        do {
            Numbers playerNumbers = new Numbers(inputView.createPlayerNumber());
            Referee referee = new Referee(computerNumbers);

            int strike = referee.countStrike(playerNumbers);
            int ball = referee.countBall(playerNumbers);
            outputView.printResult(strike, ball);
            if (strike == THREE_STRIKE) {
                break;
            }
        } while (true);
    }
}
