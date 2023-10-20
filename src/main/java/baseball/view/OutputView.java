package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public static void gameStartOutput() {
        System.out.println(START_MESSAGE);
    }

    public static void gameResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
            return;
        }
        if(ballCount > 0 && strikeCount > 0){
            System.out.println(ballCount+BALL+" "+strikeCount+STRIKE);
            return;
        }
        if (strikeCount == 0) {
            System.out.println(ballCount + BALL+" ");
            return;
        }
        if(ballCount == 0){
            System.out.println(strikeCount+STRIKE);
        }
    }

    public static void gameEndOutput() {
        System.out.println(GAME_END_MESSAGE);
    }


}
