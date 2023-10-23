package baseball;

public class Output {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printGameResult(int strikeCount, int ballCount) {
        StringBuilder stringBuilder = new StringBuilder();
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append("스트라이크");
        }
        System.out.println(stringBuilder);
    }
}
