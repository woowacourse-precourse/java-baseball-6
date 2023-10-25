package baseball.view;

import baseball.model.GameResult;

public class OutputView {

    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String INPUT_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private final static String GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }
    public static void printInputNumberMessage(){
        System.out.println(INPUT_PLAYER_NUMBER_MESSAGE);
    }

    public static void printRestartMessage(){
        System.out.println(INPUT_RESTART_MESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    public static void printGameResult(GameResult gameResult){

        int ballCount = gameResult.getBallCount();
        int strikeCount = gameResult.getStrikeCountCount();

       StringBuffer result = new StringBuffer();

        if (ballCount == 0 && strikeCount == 0) result.append(NOTHING_MESSAGE);
        else{
            if (ballCount != 0) result.append(ballCount).append(BALL_MESSAGE).append(" ");
            if (strikeCount != 0) result.append(strikeCount).append(STRIKE_MESSAGE);
        }

        System.out.println(result);
    }

}
