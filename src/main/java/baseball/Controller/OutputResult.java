package baseball.Controller;

import baseball.Utils.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class OutputResult {

    static final String REGAME = "1";
    static final String EXIT = "2";

    public Boolean result(int strike, int ball) {

        StartGame startGame = new StartGame();

        if (ball == 0 && strike == 0) {
            System.out.println(GameMessage.NOTHING);
            return false;
        }
//        if (ball != 0) {
//            System.out.print(ball + GameMessage.BALL);
//            return false;
//        }
//        if (strike != 0) {
        else {
            if(strike == 3) {
                System.out.println(GameMessage.OUTPUT);
                System.out.println(GameMessage.END);
                String choice = Console.readLine();
                if(choice.equals(REGAME)) {
                    startGame.reStart();
                }else if(choice.equals(EXIT)){
                    return true;
                }else{
                    // 1 또는 2가 아닌 수 입력 시 예외처리
                    System.out.println("예외처리");
                    return false;
                }
            }
            System.out.print(ball + GameMessage.BALL);
            System.out.println(strike + GameMessage.STRIKE);
        }
        return false;
    }
}
