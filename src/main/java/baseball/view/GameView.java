package baseball.view;

import baseball.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private final String ANSWERMESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public String getPlayerInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        InputValidator.validatePlayNumber(input);

        return input;
    }

    public int gameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        InputValidator.validateGameContinue(input);

        return Integer.parseInt(input);
    }

    public void showIntro() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void showResult(int strike, int ball) {
        if(strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
            if(strike == 3) {
                System.out.println(ANSWERMESSAGE);
            }
        }

        else if(strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }

        else if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
