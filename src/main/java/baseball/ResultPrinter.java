package baseball;

public class ResultPrinter {
    private static boolean isDone = false;

    public static void printResult(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isDone = true;
            }
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else {
            System.out.println("낫싱");
        }
    }

    public static void initializeFiled() {
        isDone = false;
    }

    public static boolean isDone() {
        return isDone;
    }
}
