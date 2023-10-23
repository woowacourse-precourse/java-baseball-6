package baseball.controller;

import baseball.AppConfig;
import baseball.member.ComputerNumbers;
import baseball.member.RestartOption;
import baseball.member.PlayerNumbers;
import baseball.view.OutputView;

public class BaseballGameController {
    public static final int GAME_NUMBER_DIGIT = 3;
    private PlayerNumbers playerNumbers;
    private ComputerNumbers computerNumbers;
    private final RestartOption restartOption;
    private final StrikeBallCountable strikeBallCountable;

    public BaseballGameController(StrikeBallCountable strikeBallCountable, RestartOption restartOption) {
        this.strikeBallCountable = strikeBallCountable;
        this.restartOption = restartOption;
    }

    public void playBaseballGame() {
        OutputView.printGameStartMessage();
        do {
            playOneBaseballGame();
        } while(restartOption.wantRestartGame());
    }

    private void playOneBaseballGame() {
        setComputerNumbers();
        do {
            inputPlayerNumbers();
            strikeBallCountable.countStrikeAndBall(playerNumbers, computerNumbers);
        } while(!strikeBallCountable.isGameClear());
    }

    private void setComputerNumbers() {
        this.computerNumbers = new ComputerNumbers();
    }

    private void inputPlayerNumbers() {
        this.playerNumbers = new PlayerNumbers();
    }
}
