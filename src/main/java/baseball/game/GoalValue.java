package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.regex.Pattern;

public class GoalValue {
    private final String value;
    private static final int VALUE_LENGTH = 3;

    public static GoalValue create(String value) {
        validate(value);
        return new GoalValue(value);
    }

    public static GoalValue createRandom() {
        StringBuilder sb = new StringBuilder();
        for (int num : Randoms.pickUniqueNumbersInRange(1, 9, VALUE_LENGTH)) {
            sb.append(num);
        }

        return create(sb.toString());
    }

    private static void validate(String value) {
        boolean isNumberMatchesLength = Pattern.matches("^[1-9]{" + VALUE_LENGTH + "}$", value);
        if (!isNumberMatchesLength) {
            throw new IllegalArgumentException("길이가 3이어야 합니다.");
        }

        HashSet<Character> duplicateDetectorSet = new HashSet<>();
        for (int i = 0; i < value.length(); i++) {
            char num = value.charAt(i);
            if (duplicateDetectorSet.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
            }
            duplicateDetectorSet.add(num);
        }
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

    private GoalValue(String value) {
        this.value = value;
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
