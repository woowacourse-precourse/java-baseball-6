package baseball;

import java.util.HashMap;

public class Output {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printResult(HashMap<String, Integer> result) {
        int strike = result.get("strike");
        int ball = result.get("ball");
        if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (ball > 0 && strike == 0) {
            System.out.printf("%d볼\n", ball);
        } else if (strike > 0 && ball == 0) {
            System.out.printf("%d스트라이크\n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크\n",ball, strike);
        }
    }

    public static void printSuccessMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
