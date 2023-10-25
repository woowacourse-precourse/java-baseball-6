package baseball.view;

import baseball.util.InputValidate;
import camp.nextstep.edu.missionutils.Console;

public class AppView {
    private AppView() {
    }

    public static void output (String aString) {
        System.out.print(aString);
    }
    public static void outputLine (String aString) {
        System.out.println(aString);
    }

    public static void outputStart () {
        outputLine("숫자 야구 게임을 시작합니다.");
    }

    public static void outputState (int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        if (ball + strike == 0){
            sb.append("낫싱");
        }
        System.out.println(sb);
    }

    public static void outputSuccess () {
        outputLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static int inputNumber () {
        output("숫자를 입력해주세요 : ");
        String number = Console.readLine();
        return InputValidate.checkInputNumber(number);
    }

    public static int inputCommand () {
        outputLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int command = Integer.parseInt(Console.readLine());
        return InputValidate.checkCommand(command);
    }
}
