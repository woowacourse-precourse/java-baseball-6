package baseball.View;
import baseball.domain.GameResult;
import java.util.ArrayList;

public class OutputView {
    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요 : "; //게임 시작 문구 출력
    private static final String BALL_MESSAGE = "%d볼"; //입력한 수에 대한 결과를 볼 개수로 표시
    private static final String STRIKE_MESSAGE = "%d스트라이크"; //입력한 수에 대한 결과를 스트라이크 개수로 표시
    private static final String NOTHING_MESSAGE = "낫싱"; //하나도 없는 경우
    private final static String GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"; //3개의 숫자를 모두 맞힐 경우
    private final static String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."; //게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수
    public static void printStartGameMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    public static void printResult(GameResult gameResult) {
        int ballCount = gameResult.getBallCount();
        int strikeCount = gameResult.getStrikeCountCount();

        ArrayList<String> result = new ArrayList<>();
        if (ballCount == 0 && strikeCount == 0) result.add(NOTHING_MESSAGE);
        if (ballCount != 0) result.add(String.format(BALL_MESSAGE, ballCount));
        if (strikeCount != 0) result.add(String.format(STRIKE_MESSAGE, strikeCount));

        System.out.println(String.join(" ", result));
    }

    public static void printRestartOrEnd() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
    }
}