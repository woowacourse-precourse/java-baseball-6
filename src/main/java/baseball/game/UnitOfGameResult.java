package baseball.game;

public class UnitOfGameResult {
    public static void printResult(int ball, int strike) {
        if (ball == 0 & strike == 0) {
            System.out.println("낫싱");
        } else if (ball != 0 & strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 & strike > 0 & strike < 3) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0 & strike > 0 & strike < 3) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
