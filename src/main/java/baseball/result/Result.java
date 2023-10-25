package baseball.result;

/**
 * 숫자 야구 게임 후 비교 결과가 저장되는 클래스이다.
 *
 * @author Seongha Park
 */
public class Result {
    private Status strike;
    private Status ball;
    private static final int MAX_COUNT = 3;
    private static final int MIN_COUNT = 0;

    /**
     * 생성자를 통해 필드를 주입받아 비교 후 바로 ball, strike가 존재하는 객체를 만들 수 있다.
     */
    public Result(Status ball, Status strike) {
        this.strike = strike;
        this.ball = ball;
    }

    /**
     * strike, ball이 모두 0일 경우 낫싱을 출력한다. ball, strike 각각에는 0이 아닐 경우를 제외하여 낫싱과 이중 출력되는 부분을 방지했다.
     */
    public void checkResult() {
        if (strike.count() == MIN_COUNT && ball.count() == MIN_COUNT) {
            System.out.print("낫싱");
        }
        printResult();
    }

    /**
     * Result 클래스를 출력한다. ball, strike 각각에는 0이 아닐 경우를 제외하여 낫싱과 이중 출력되는 부분을 방지했다.
     */
    public void printResult() {
        printBall();
        printStrike();
        System.out.println();
    }

    private void printBall() {
        if (ball.count() != MIN_COUNT) {
            System.out.print(ball.count() + "볼 ");
        }
    }

    private void printStrike() {
        if (strike.count() != MIN_COUNT) {
            System.out.print(strike.count() + "스트라이크");
        }
    }

    /**
     * 3스트라이크일 경우 이겼다.
     *
     * @return 스트라이크 개수가 3개인지 확인하고 맞을 경우 true, 틀린 경우 false를 반환한다.
     */
    public boolean isWin() {
        return strike.count() == MAX_COUNT;
    }

    /**
     * 3스트라이크시의 문구를 출력한다.
     */
    public void printWin() {
        System.out.println(MAX_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
