package baseball.model;

import java.util.Map;
import java.util.function.BooleanSupplier;

public class StopGameDecisionHelper {

    private static final int MORE_NUMBER = 1;
    private static final int END_NUMBER = 2;
    public static final String MORE_GAME_TEXT =
            "게임을 새로 시작하려면 " + MORE_NUMBER + ", 종료하려면 " + END_NUMBER + "를 입력하세요.";
    private static final Map<Integer, BooleanSupplier> DECISION_HELPER = Map.of(
            MORE_NUMBER, () -> false,
            END_NUMBER, () -> true
    );

    private StopGameDecisionHelper() {
    }

    public static boolean getDecision(int decisionValue) {
        return DECISION_HELPER.getOrDefault(decisionValue, wrongInput())
                .getAsBoolean();
    }

    private static BooleanSupplier wrongInput() {
        return () -> {
            throw new IllegalArgumentException();
        };
    }
}
