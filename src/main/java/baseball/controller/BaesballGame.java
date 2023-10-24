package baseball.controller;

import static baseball.utils.Constants.*;

import baseball.model.BaseballGameStatus;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.BaseballGameView;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;


public class BaesballGame {
    private final Computer computer;
    private final Player player;
    private final BaseballGameStatus status;
    private final BaseballGameView view;


    public BaesballGame() {

        this.view = new BaseballGameView();
        this.computer = new Computer();
        this.player = new Player();
        this.status = new BaseballGameStatus();
    }

    public void run() {
        view.startGame();
        computer.reset();
        computer.setAnswer();

        while(this.status.isGameInProgress()) {
            view.enterNumber();
            String answer = Console.readLine();
            player.reset();
            player.setAnswer(answer);

            status.reset();

            this.compare();
            if(this.isMaxStrike()) {
                view.restartOrQuit();
                String restartFlag = Console.readLine();
                if(restartFlag.equals(GAME_FLAG_START)) {
                    this.status.setGameInProgress(true);
                    computer.reset();
                    computer.setAnswer();

                    status.reset();
                } else if(restartFlag.equals(GAME_FLAG_END)) {
                    this.status.setGameInProgress(false);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void compare() {
        for(int i=ZERO; i<BALL_MAX; i++) {
            int playerAnswer = this.player.getAnswerSequence()[i];
            int computerDigitPositionValue = this.computer.getDigitPositions()[playerAnswer];

            if(computerDigitPositionValue > INIT_VALUE) {
                if(computerDigitPositionValue == i) {
                    this.status.increaseStrike();
                } else {
                    this.status.increaseBall();
                }
            }
        }

        view.resultByScore(status.getBall(), status.getStrike(), BALL_MAX);
    }

    private boolean isMaxStrike() {
        return Objects.equals(this.status.getStrike(), BALL_MAX);
    }
}
