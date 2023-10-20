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

    public static boolean reGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String continued = Console.readLine();

        InputDataExceptionHandler.validateReGame(continued);

        if(continued.equals("1")) {
            return true;
        } else {
            return false;
        }
    }
}
