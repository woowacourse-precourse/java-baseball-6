package baseball.view;

public class SystemMessage {
    public void printScore(int ball, int strike) {
        if (ball == 0 && strike != 0)
            System.out.println(strike + "스트라이크");

        if (ball != 0 && strike == 0)
            System.out.println(ball + "볼");

        if (ball != 0 && strike != 0)
            System.out.println(ball + "볼 " + strike + "스트라이크");

        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
    }

    public static void printGameOver() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
