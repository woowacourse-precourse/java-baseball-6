package baseball.game.umpire;

import baseball.game.CheckingBoard;
import baseball.game.Score;

import java.util.Arrays;

import static baseball.AppConfig.DIGIT_NUM;

public class ComputerUmpireImpl implements Umpire {

    @Override
    public CheckingBoard checkStrike(String ball, String bat, CheckingBoard checkingBoard) {
        Boolean[] strikeCheckingBoard = checkingBoard.getStrikeCheckingBoard();
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(ball.charAt(i) == bat.charAt(i)){
                strikeCheckingBoard[i] = true;
            }
        }
        checkingBoard.setStrikeCheckingBoard(strikeCheckingBoard);
        return checkingBoard;
    }

    @Override
    public CheckingBoard checkBall(String ball, String bat, CheckingBoard checkingBoard) {
        Boolean[] strikeCheckingBoard = checkingBoard.getStrikeCheckingBoard();
        Boolean[] ballCheckingBoard = checkingBoard.getBallCheckingBoard();

        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(strikeCheckingBoard[i] == true){continue;}
            for(int j = 0 ; j < DIGIT_NUM ; j++){
                if(strikeCheckingBoard[j] == true){continue;}
                if(ballCheckingBoard[j] == true){continue;}
                if(ball.charAt(i) == bat.charAt(j)){
                    ballCheckingBoard[j] = true;
                    break;
                }
            }
        }
        checkingBoard.setBallCheckingBoard(ballCheckingBoard);
        return checkingBoard;
    }

    @Override
    public Score judge(CheckingBoard checkingBoard, Score score) {
        int strike = 0;
        int ball = 0;
        boolean homerun = false;
        boolean nothing = false;
        Boolean[] strikeCheckingBoard = checkingBoard.getStrikeCheckingBoard();
        Boolean[] ballCheckingBoard = checkingBoard.getBallCheckingBoard();

        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(strikeCheckingBoard[i] == true){
                strike++;
            }
        }
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(ballCheckingBoard[i] == true){
                ball++;
            }
        }
        if(strike == DIGIT_NUM){
            homerun = true;
        }
        if(strike == 0 && ball == 0){
            nothing = true;
        }

        score.setAll(strike, ball, homerun, nothing);

        return score;
    }
}
