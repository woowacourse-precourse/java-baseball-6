package baseball;

/**
 * 심판 클래스로부터 결과를 받아서 출력하는 클래스입니다.
 */
public class DisplayManager {
    public static void printResult(int[] result) {
        int ball = result[1];
        int strike = result[0];

        if (strike == 3) {
            System.out.println("3스트라이크");
        } else if (ball > 0 || strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }
}
