package baseball;

public class Print {
    static void Result_print(int ball, int strike) {
        // 둘다 0인경우
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        // ball 만 0인 경우
        else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        // strike 만 0인경우
        else if (strike == 0) {
            System.out.println((ball + "볼"));
        }

        // 나머지
        else {
            System.out.println(ball + "볼" + " " + strike + "스트라이크");
        }
    }
}