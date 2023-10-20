package baseball.game;

import java.util.regex.Pattern;

public class GoalValue {
    private final String value;

    public static GoalValue create(String value) {
        if (!validate(value)) {
            throw new IllegalArgumentException("입력값의 형식이 올바르지 않습니다.");
        }
        return new GoalValue(value);
    }

    private static boolean validate(String value) {
        boolean isNumberWithLength3 = Pattern.matches("^[1-9]{3}$", value);
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
        return null;
    }

    @Override
    public String toString() {
        return "GoalValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
