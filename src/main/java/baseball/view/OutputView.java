package baseball.view;

public class OutputView {
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static final String STRIKE = "스트라이크";

    public static final String BALL = "볼";

    public static final String NOTHING = "낫싱";

    public static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static final String SELECT_GAME_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printInputMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(END_GAME_MESSAGE);
    }

    public void printSelectMessage() {
        System.out.println(SELECT_GAME_AGAIN_MESSAGE);
    }

    public void printGameResultMessage(int ballCnt, int strikeCnt) {
        if (ballCnt > 0 && strikeCnt > 0) {
            System.out.println(ballCnt + BALL + " " + strikeCnt + STRIKE);
        } else if (ballCnt > 0 && strikeCnt == 0) {
            System.out.println(ballCnt + BALL);
        } else if (ballCnt == 0 && strikeCnt > 0) {
            System.out.println(strikeCnt + STRIKE);
        } else if (ballCnt == 0 && strikeCnt == 0) {
            System.out.println(NOTHING);
        }
    }
}
