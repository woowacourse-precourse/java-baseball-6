package baseball.controller;

import static baseball.utils.Constants.*;
import baseball.model.Computer;
import baseball.model.Player;
import baseball.utils.MessageUtils;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;


public class BaesballGame {
    private final Computer computer;
    private final Player player;


    private Integer ball;
    private Integer strike;
    private Boolean isGameInProgress;


    public BaesballGame() {
        this.isGameInProgress = true;

        this.computer = new Computer();
        this.player = new Player();
    }

    public void run() {
        MessageUtils.startGame();
        computer.reset();
        computer.setAnswer();

        while(this.isGameInProgress) {
            MessageUtils.enterNumber();
            String answer = Console.readLine();
            player.reset();
            player.setAnswer(answer);

            this.compare();
            if(this.isMaxStrike()) {
                MessageUtils.restartOrQuit();
                String restartFlag = Console.readLine();
                if(restartFlag.equals(GAME_FLAG_START)) {
                    this.isGameInProgress = true;
                    computer.setAnswer();
                } else if(restartFlag.equals(GAME_FLAG_END)) {
                    this.isGameInProgress = false;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    private void compare() {
        this.ball = ZERO;
        this.strike = ZERO;

        for(int i=ZERO; i<BALL_MAX; i++) {
            int playerAnswer = this.player.getAnswerSequence()[i];
            int computerDigitPositionValue = this.computer.getDigitPositions()[playerAnswer];

            if(computerDigitPositionValue > INIT_VALUE) {
                if(computerDigitPositionValue == i) {
                    this.strike++;
                } else {
                    this.ball++;
                }
            }
        }

        MessageUtils.result(ball, strike, BALL_MAX);
    }

    private boolean isMaxStrike() {
        return Objects.equals(this.strike, BALL_MAX);
    }
}
