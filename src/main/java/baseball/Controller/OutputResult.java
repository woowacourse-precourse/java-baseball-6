package baseball.Controller;

import baseball.Utils.ExceptionProcess;
import baseball.Utils.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class OutputResult {

    static final String REGAME = "1";
    static final String EXIT = "2";

    public Boolean result(int strike, int ball) {

        StartGame startGame = new StartGame();
        ExceptionProcess exceptionProcess = new ExceptionProcess();

        if (ball == 0 && strike == 0) {
            System.out.println(GameMessage.NOTHING);
            return true;
        } else {
            if (strike == 3) {
                System.out.println(strike + GameMessage.STRIKE);
                System.out.println(GameMessage.OUTPUT);
                System.out.println(GameMessage.CHOICE);
                String choice = Console.readLine();
                exceptionProcess.enterRestartAndExitException(choice);
                // 1 or 2를 제외한 입력시 예외 처리
                if (choice.equals(REGAME)) {
                    startGame.reStart();
                    return false;
                } else if (choice.equals(EXIT)) {
                    System.out.println(GameMessage.END);
                    return false;
                } else {
                    return null;
                }
            } else {
                System.out.print(ball + GameMessage.BALL);
                System.out.println(strike + GameMessage.STRIKE);
                return true;
            }
        }
    }
}
