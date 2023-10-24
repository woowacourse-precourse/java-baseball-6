package baseball;

/**
 * 개별 숫자 야구 게임을 실행하기 위한 클래스.
 */
public class Game {
    private static Preference settings;

    /**
     * 게임을 시작합니다.
     * <p>
     * 투수 역할의 Player 객체를 무작위로 생성하고, 사용자에게 입력을 받아 타자 역할의 Player 객체를 매번 생성합니다.
     * <p>
     * 둘을 비교하여 결과를 출력합니다.
     *
     * @param preference 이번 게임에서 사용할 숫자 길이와 범위
     */
    public static void start(Preference preference) {
        settings = preference;

        Player pitcher = new Player(settings);
        Result result;

        do {
            Player hitter = new Player(Reader.readNumber(settings));
            result = pitcher.compareWith(hitter);
            Printer.printResult(result);
        } while (!foundAnswer(result));
    }

    /**
     * 투수 객체와 타자 객체를 비교한 결과가 모두 스트라이크인지 비교합니다.
     *
     * @param result 비교 결과를 담은 Result 레코드
     * @return 모두 스트라이크이면 true, 아니면 false 반환.
     */
    public static boolean foundAnswer(Result result) {
        if (result.strike() == settings.answerSize()) {
            System.out.printf("%d%s\n", settings.answerSize(), Printer.TERMINATE_MESSAGE);
            return true;
        }
        return false;
    }
}
