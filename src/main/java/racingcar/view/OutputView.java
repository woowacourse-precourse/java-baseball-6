package racingcar.view;

import java.util.*;

public class OutputView {
    public void showCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showAttemptsInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showAttemptResult(Map<String, Integer> attemptResult) {
        for (Map.Entry<String, Integer> entry : attemptResult.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue();

            String result = "-".repeat(count);
            System.out.println(name + " : " + result);
        }
    }

    public void showGameResult(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }
}
