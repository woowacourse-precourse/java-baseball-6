package baseball.model;

import java.util.Map;
import java.util.function.BooleanSupplier;

public class StopGameDecisionHelper {

    public static final int MORE_NUMBER = 1;
    public static final int END_NUMBER = 2;
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
