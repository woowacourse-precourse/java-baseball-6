package baseball.view;

import baseball.constants.AppConstants;
import camp.nextstep.edu.missionutils.Console;

public class GameIO {
    /*
    * 게임 재시작 입력값 받기
    * */
    public String getContinueGameString() {
        return Console.readLine();
    }
    /*
    * 사용자 게임 입력값 받기
    * */
    public String getUserGameInput() {
        return Console.readLine();
    }
    /*
    * game 시작시 출력
    * */
    public void printStartGame() {
        System.out.println(AppConstants.MSG_START_GAME);
    }
    /*
     * 스테이지 시작시 출력
     * */
    public void printInputNumber() {
        System.out.println(AppConstants.MSG_INPUT_NUMBER);
    }
    public void printTreeStrike() {
        System.out.println("3" + AppConstants.RESULT_GAME_STRIKE);
        System.out.println(AppConstants.MSG_END_GAME);
    }
    public void printBallAndStrike(int ball, int strike) {
        System.out.println(ball + AppConstants.RESULT_GAME_BALL + " "+
                strike + AppConstants.RESULT_GAME_STRIKE);
    }
    public void printStrike (int strike){
        System.out.println(strike + AppConstants.RESULT_GAME_STRIKE);
    }
    public void printBall (int ball){
        System.out.println(ball + AppConstants.RESULT_GAME_BALL);
    }
    public void printNoting() {
        System.out.println(AppConstants.RESULT_GAME_NOTHING_MSG);
    }
    public void printGameMsg() {
        System.out.println(AppConstants.MSG_RESTART_GAME);
    }


}
