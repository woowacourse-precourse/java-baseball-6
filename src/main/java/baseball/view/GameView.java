package baseball.view;

import baseball.utility.InputDataExceptionHandler;
import camp.nextstep.edu.missionutils.Console;


public class GameView {
    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String userInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInputNumbers = Console.readLine();
        InputDataExceptionHandler.validateNumbers(userInputNumbers);

        return userInputNumbers;
    }

    public static void gameResult(int ball, int strike) {
        String result;

        if(ball == 0 && strike == 0) {
            result = "낫싱";
        } else if(ball == 0) {
            result = strike + "스트라이크";
        } else if(strike == 0) {
            result = ball + "볼";
        } else {
            result = ball + "볼 " + strike + "스트라이크";
        }

        System.out.println(result);
    }
}
