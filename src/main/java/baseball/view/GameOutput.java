package baseball.view;

public class GameOutput {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String RESULT_BALL = "%d볼 ";
    private static final String RESULT_STRIKE = "%d스트라이크 ";
    private static final String RESULT_NON_MATCHED = "낫싱";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public void printResult(Integer ballCount, Integer strikeCount) {
        if (ballCount > 0) System.out.print(RESULT_BALL);
        if (strikeCount > 0) System.out.print(RESULT_STRIKE);
        if (ballCount == 0 && strikeCount == 0) System.out.print(RESULT_NON_MATCHED);

        System.out.println();
    }

    public void printEndGame() {
        System.out.println(END_GAME);
    }
}
