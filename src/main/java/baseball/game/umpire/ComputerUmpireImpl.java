package baseball.game.umpire;

import baseball.game.CheckingBoard;
import baseball.game.Score;

import static baseball.AppConfig.DIGIT_NUM;

public class ComputerUmpireImpl implements Umpire {
    @Override
    public CheckingBoard checkStrike(String ball, String bat, CheckingBoard checkingBoard) {
        Boolean[] strikeCheckingBoard = checkingBoard.getStrikeCheckingBoard();
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            //공과 배트의 숫자가 같은 위치 같은 숫자일 경우
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
            //공의 위치가 스트라이크 판정 확인 시
            if(strikeCheckingBoard[i] == true){continue;}
            for(int j = 0 ; j < DIGIT_NUM ; j++){
                //배트의 위치가 스트라이크 판정 확인 시
                if(strikeCheckingBoard[j] == true){continue;}
                //이미 볼 판정 된 배트일 경우
                if(ballCheckingBoard[j] == true){continue;}
                //i번째 위치의 공과 j번째 위치의 배트의 숫자가 같을 경우
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

        //스트라이크 갯수 확인
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(strikeCheckingBoard[i] == true){
                strike++;
            }
        }
        //볼 갯수 확인
        for(int i = 0 ; i < DIGIT_NUM ; i++){
            if(ballCheckingBoard[i] == true){
                ball++;
            }
        }
        //홈런 여부 확인
        if(strike == DIGIT_NUM){
            homerun = true;
        }
        //낫싱 여부 확인
        if(strike == 0 && ball == 0){
            nothing = true;
        }
        score.setAll(strike, ball, homerun, nothing);
        return score;
    }
}
