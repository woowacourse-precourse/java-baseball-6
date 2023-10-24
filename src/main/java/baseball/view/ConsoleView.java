package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleView {
    public static void gameStartView() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static String userNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static void nothing() {
        System.out.println("낫싱");
    }

    public static void gameEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void ballStrike(int ball, int strike) {
        StringBuilder sb = new StringBuilder();
        if (ball==0) {
            sb.append(strike + "스트라이크");
        } else if (strike == 0) {
            sb.append(ball+"볼");
        }
        else {
            sb.append(ball+"볼"+" "+strike+"스트라이크");
        }
        System.out.println(sb);
    }

    public static String reGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
