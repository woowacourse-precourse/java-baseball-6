package racingcar.view;

import java.util.*;

public class OutputView {
    private static final String NAME_INPUT_MESSAGE  = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String POSITION_SYMBOL = "-";
    private static final String NAME_RESULT_DIVIDER = " : ";
    private static final String NAME_DELIMITER = ", ";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String ATTEMPT_RESULT = "\n실행 결과";

    public void showCarNamesInputMessage() {
        System.out.println(NAME_INPUT_MESSAGE);
    }

    public void showAttemptsInputMessage() {
        System.out.println(ATTEMPT_INPUT_MESSAGE);
    }

    public void showAttemptResultStartMessage() {
        System.out.println(ATTEMPT_RESULT);
    }

    public void showAttemptResult(Map<String, Integer> attemptResult) {
        for (Map.Entry<String, Integer> entry : attemptResult.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();

            String position = POSITION_SYMBOL.repeat(count);
            System.out.println(name + NAME_RESULT_DIVIDER + position);
        }
        System.out.println();
    }

    public void showGameResult(List<String> winners) {
        String winnersString = String.join(NAME_DELIMITER, winners);
        System.out.println(FINAL_WINNER + NAME_RESULT_DIVIDER + winnersString);
    }
}
