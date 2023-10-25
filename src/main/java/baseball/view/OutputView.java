package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printResult(List<Integer> result) {
        List<String> resultMessage = new ArrayList<>();
        if (isNothing(result)) {
            System.out.println("낫싱");
            return;
        }
        if (hasBall(result)) {
            resultMessage.add(result.get(0) + "볼");
        }
        if (hasStrike(result)) {
            resultMessage.add(result.get(1) + "스트라이크");
        }
        System.out.println(String.join(" ", resultMessage));
    }

    private static boolean isNothing(List<Integer> result) {
        return result.get(0) == 0 && result.get(1) == 0;
    }

    private static boolean hasBall(List<Integer> result) {
        return result.get(0) > 0;
    }

    private static boolean hasStrike(List<Integer> result) {
        return result.get(1) > 0;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
