package baseball.view;

/**
 * 게임에 대한 상태를 출력하는 역할을 수행한다.
 */
public class OutputView {

    private OutputView() {
    }

    /**
     * 게임 시작 문구를 출력한다.
     */
    public static void printBeginningMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * 볼과 스트라이크의 개수를 받아 힌트를 출력한다.
     */
    public static void printBallCountResult(int countOfBall, int countOfStrike) {
        if (isNothing(countOfBall, countOfStrike)) {
            System.out.println("낫싱");
            return;
        }
        if (isCountOfStrikeZero(countOfStrike)) {
            System.out.println(countOfBall + "볼");
            return;
        }
        if (isCountOfBallZero(countOfBall)) {
            System.out.println(countOfStrike + "스트라이크");
            return;
        }
        System.out.println(countOfBall + "볼 " + countOfStrike + "스트라이크");
    }

    private static boolean isNothing(int countOfBall, int countOfStrike) {
        return isCountOfStrikeZero(countOfStrike) && isCountOfBallZero(countOfBall);
    }

    private static boolean isCountOfStrikeZero(int countOfStrike) {
        return countOfStrike == 0;
    }

    private static boolean isCountOfBallZero(int countOfBall) {
        return countOfBall == 0;
    }

    /**
     * 게임 종료 문구를 출력한다.
     */
    public static void printEndingMessageForAllStrike(int digitNumber) {
        System.out.println(digitNumber + "스트라이크\n"
                + digitNumber + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
