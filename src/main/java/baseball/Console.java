package baseball;

import java.util.ArrayList;

public class Console {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String BALL_COUNT_MESSAGE = "%d볼";
    private static final String STRIKE_COUNT_MESSAGE = "%d스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printSuccessEndMessage() {
        System.out.println(SUCCESS_END_MESSAGE);
    }

    public static void printGameRestartOrEndMessage() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
    }

    public static void printResult(int ballCount, int strikeCount) {
        ArrayList<String> result = new ArrayList<>();

        if (ballCount > 0) {
            result.add(String.format(BALL_COUNT_MESSAGE, ballCount));
        }
        if (strikeCount > 0) {
            result.add(String.format(STRIKE_COUNT_MESSAGE, strikeCount));
        }

        System.out.println(result.isEmpty() ? NOTHING_MESSAGE : String.join(" ", result));
    }

    private static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    public static String readNumbers() {
        String input = readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        } else if (input.chars().anyMatch(ch -> ch < '1' || ch > '9')) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
        } else if (input.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.");
        }

        return input;
    }

    public static String readRestartOrEnd() {
        String input = readLine();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
        return input;
    }
}
