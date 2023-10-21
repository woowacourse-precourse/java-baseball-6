package baseball.view;

public class OutputView {

    private OutputView() {
    }

    public static void printBeginningMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printBallCountResult(int countOfBall, int countOfStrike) {
        if (isNothing(countOfBall, countOfStrike)) {
            System.out.println("낫싱");
            return;
        }
        if (isOnlyBall(countOfStrike)) {
            System.out.println(countOfBall + "볼");
            return;
        }
        if (isOnlyStrike(countOfBall)) {
            System.out.println(countOfStrike + "스트라이크");
            return;
        }
        System.out.println(countOfBall + "볼 " + countOfStrike + "스트라이크");
    }

    private static boolean isNothing(int countOfBall, int countOfStrike) {
        return countOfBall == 0 && countOfStrike == 0;
    }

    private static boolean isOnlyBall(int countOfStrike) {
        return countOfStrike == 0;
    }

    private static boolean isOnlyStrike(int countOfBall) {
        return countOfBall == 0;
    }

    public static void printEndingMessageForAllStrike(int digitNumber) {
        System.out.println(digitNumber + "스트라이크\n"
                + digitNumber + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
