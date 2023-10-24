package baseball;

/**
 * 프로그램 전역에서 사용하는 문자열을 포장하고, 게임의 결과를 사용자에게 출력하기 위한 클래스.
 */
public class Printer {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String TERMINATE_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    /**
     * 투수 객체와 타사 객체를 비교한 결과를 출력합니다.
     *
     * @param result 스트라이크 수, 볼 수를 담은 Result 레코드
     */
    public static void printResult(Result result) {
        if (result.strike() > 0 && result.ball() > 0) {
            System.out.printf("%d볼 %d스트라이크\n", result.strike(), result.ball());
        } else if (result.strike() > 0) {
            System.out.printf("%d스트라이크\n", result.strike());
        } else if (result.ball() > 0) {
            System.out.printf("%d볼\n", result.ball());
        } else if (result.strike() == 0 && result.ball() == 0) {
            System.out.println("낫싱");
        }
    }
}
