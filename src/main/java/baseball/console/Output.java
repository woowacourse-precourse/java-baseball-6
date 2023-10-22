package baseball.console;

import java.util.Objects;

public class Output {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static Boolean showResult(Integer ball, Integer strike) {
        if (Objects.equals(strike, Integer.valueOf(3))) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return Boolean.TRUE;
        }

        if (strike + ball == 0) {
            System.out.println("낫싱");
            return Boolean.FALSE;
        }

        System.out.println(ball + "볼 " + strike + "스트라이크");
        return Boolean.FALSE;
    }
}
