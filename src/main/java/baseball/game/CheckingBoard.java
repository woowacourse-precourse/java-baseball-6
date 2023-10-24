package baseball.game;

import java.util.Arrays;

import static baseball.AppConfig.DIGIT_NUM;

public class CheckingBoard {
    Boolean[] strikeCheckingBoard = new Boolean[DIGIT_NUM];
    Boolean[] ballCheckingBoard = new Boolean[DIGIT_NUM];

    public void CheckingBoard() {
        Arrays.fill(strikeCheckingBoard, false);
        Arrays.fill(ballCheckingBoard, false);
    }

    public Boolean[] getStrikeCheckingBoard() {
        return strikeCheckingBoard;
    }

    public void setStrikeCheckingBoard(Boolean[] strikeCheckingBoard) {
        this.strikeCheckingBoard = strikeCheckingBoard;
    }

    public Boolean[] getBallCheckingBoard() {
        return ballCheckingBoard;
    }

    public void setBallCheckingBoard(Boolean[] ballCheckingBoard) {
        this.ballCheckingBoard = ballCheckingBoard;
    }
}
