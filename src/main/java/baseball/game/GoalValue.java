package baseball.game;

import java.util.regex.Pattern;

public class GoalValue {
    private final String value;
    private static final int VALUE_LENGTH = 3;

    public static GoalValue create(String value) {
        if (!validate(value)) {
            throw new IllegalArgumentException("입력값의 형식이 올바르지 않습니다.");
        }
        return new GoalValue(value);
    }

    private static boolean validate(String value) {
        boolean isNumberWithLength3 = Pattern.matches("^[1-9]{" + VALUE_LENGTH + "}$", value);
        if (!isNumberWithLength3) {
            return false;
        }
        return (value.charAt(0) != value.charAt(1))
                && (value.charAt(1) != value.charAt(2))
                && (value.charAt(2) != value.charAt(0));
    }

    private GoalValue(String value) {
        this.value = value;
    }

    public static CompareResult compare(GoalValue goalValue1, GoalValue goalValue2) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < VALUE_LENGTH; i++) {
            for (int j = 0; j < VALUE_LENGTH; j++) {
                if (goalValue1.value.charAt(i) != goalValue2.value.charAt(j)) {
                    continue;
                }

                if (i == j) {
                    strike++;
                } else {
                    ball++;
                }

                break;
            }
        }

        return new CompareResult(ball, strike);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "GoalValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
