package baseball.view;

import baseball.BallResultDto;

public class OutView {

    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT = "숫자를 입력해주세요 : ";
    private static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING = "낫싱";
    public static final String BALL = "볼 ";
    public static final String STRIKE = "스트라이크";

    public static void gameStartPrint() {
        System.out.println(GAME_START);
    }

    public static void numberInputPrint() {
        System.out.print(NUMBER_INPUT);
    }

    public static void ballScoringResultsPrint(BallResultDto ballResultDto) {
        System.out.println(convertBallResultToString(ballResultDto));
    }

    public static void endGamePrint() {
        System.out.println(END_GAME);
    }

    public static void restartGamePrint() {
        System.out.println(RESTART_GAME);
    }

    private static String convertBallResultToString(BallResultDto ballResultDto) {
        if (ballResultDto.getBall() == 0 && ballResultDto.getStrike() == 0) {
            return NOTHING;
        }
        StringBuilder result = new StringBuilder();
        if (ballResultDto.getBall() > 0) {
            result.append(ballResultDto.getBall()).append(BALL);
        }
        if (ballResultDto.getStrike() > 0) {
            result.append(ballResultDto.getStrike()).append(STRIKE);
        }
        return result.toString();
    }
}
