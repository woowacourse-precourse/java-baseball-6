package baseball.logic;

public record BaseballResult(
        int strike,
        int ball,
        boolean isSuccess
) {
    public static BaseballResult allStrike(int strike) {
        return new BaseballResult(strike, 0, true);
    }


    public void printSuccess() {
        System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printStatus() {
        if (ball == 0 && strike == 0) {
            printNothing();
        }
        if (ball != 0) {
            printBall();
        }
        if (strike != 0) {
            printStrike();
        }

        System.out.println();
    }

    private void printNothing() {
        System.out.print("낫싱");
    }

    private void printBall() {
        System.out.print(ball + "볼 ");
    }

    private void printStrike() {
        System.out.print(strike + "스트라이크");
    }


}
