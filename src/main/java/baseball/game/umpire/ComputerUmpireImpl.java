package baseball.game.umpire;

import baseball.game.Score;

import java.util.Arrays;

import static baseball.AppConfig.DIGIT_NUM;

public class ComputerUmpireImpl implements Umpire {

    Boolean[] strikeCheckingBoard = new Boolean[DIGIT_NUM];
    Boolean[] ballCheckingBoard = new Boolean[DIGIT_NUM];
    Boolean homerunChecker = false;
    Boolean nothingChecker = false;

    public ComputerUmpireImpl() {
        Arrays.fill(strikeCheckingBoard, false);
        Arrays.fill(ballCheckingBoard, false);
    }

    @Override
    public Boolean[] checkStrike(String ball, String bat, Boolean[] strikeCheckingBoard) {
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(ball.charAt(i) == bat.charAt(i)){
                strikeCheckingBoard[i] = true;
            }
        }
        return strikeCheckingBoard;
    }

    @Override
    public Boolean[] checkBall(String ball, String bat, Boolean[] ballCheckingBoard) {
        return new Boolean[0];
    }

    @Override
    public Boolean checkHomerun(Boolean[] strikeCheckingBoard) {
        return null;
    }

    @Override
    public Boolean checkNothing(Boolean[] strikeCheckingBoard, Boolean[] ballCheckingBoard) {
        return null;
    }

    @Override
    public Score judge(Boolean[] strikeCheckingBoard, Boolean[] ballCheckingBoard, Boolean homerunCount, Boolean nothingCount) {
        return null;
    }
}
