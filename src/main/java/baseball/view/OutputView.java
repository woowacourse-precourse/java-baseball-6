package baseball.view;

import java.util.Map;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_START_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String[] RESULT_KEYS = {"볼", "스트라이크", "낫싱"};

    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printGameResultMessage(Map<String, Integer> result) {
        StringBuilder resultSb = new StringBuilder();

        if (result.containsKey(RESULT_KEYS[2]) && result.get(RESULT_KEYS[2]) == 3) {
            resultSb.append("낫싱");
            System.out.println(resultSb);
            return;
        }

        for (int kIdx = 0; kIdx < 2; kIdx++) {
            String key = RESULT_KEYS[kIdx];
            if (result.containsKey(key)) {
                resultSb.append(result.get(key)).append(key).append(" ");
            }
        }
        System.out.println(resultSb);
    }

    public static void printThreeStrikeMessage() {
        System.out.println(THREE_STRIKE_MESSAGE);
    }

    public static void printStartNewGameMessage() {
        System.out.println(NEW_GAME_START_MESSAGE);
    }
}
