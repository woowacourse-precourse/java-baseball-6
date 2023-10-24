package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";


    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printResult(int ballCnt, int strikeCnt) {

        // 하나도 없는 경우
        if (ballCnt == 0 && strikeCnt == 0)
            System.out.println(NOTHING);

        // 볼, 스트라이크가 모두 하나 이상인 경우
        else if (ballCnt > 0 && strikeCnt > 0)
            System.out.println(ballCnt + BALL + " " + strikeCnt + STRIKE);

        // 볼만 있는 경우
        else if (ballCnt > 0 && strikeCnt == 0)
            System.out.println(ballCnt + BALL);

        // 스트라이크만 있는 경우
        else if (ballCnt == 0 && strikeCnt > 0) {
            System.out.println(strikeCnt + STRIKE);

            // 스트라이크가 3인 경우 (숫자를 맞춘 경우)
            if (strikeCnt == 3)
                System.out.println(GAME_FINISH_MESSAGE);
        }
    }
}
