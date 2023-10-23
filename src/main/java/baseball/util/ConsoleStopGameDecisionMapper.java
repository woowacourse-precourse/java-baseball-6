package baseball.util;

import java.util.Map;
import java.util.function.BooleanSupplier;

public class ConsoleStopGameDecisionMapper {

    public static final String MORE_TEXT = "1";
    public static final String STOP_TEXT = "2";
    private static final Map<String, BooleanSupplier> DECISION_HELPER = Map.of(
            MORE_TEXT, () -> false,
            STOP_TEXT, () -> true
    );

    private ConsoleStopGameDecisionMapper() {
    }

    public static boolean getDecision(String decisionValue) {
        return DECISION_HELPER.getOrDefault(decisionValue, ConsoleStopGameDecisionMapper::wrongInput)
                .getAsBoolean();
    }

    private static boolean wrongInput() {
        throw new IllegalArgumentException();
    }
}
