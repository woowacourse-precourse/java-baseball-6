package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.regex.Pattern;

public class UniqueNumberString {
    private final String value;
    private final RuleSet ruleSet;

    public static UniqueNumberString create(String value, RuleSet ruleSet) {
        validate(value, ruleSet);
        return new UniqueNumberString(value, ruleSet);
    }

    public static UniqueNumberString createRandom(RuleSet ruleSet) {
        StringBuilder sb = new StringBuilder();
        boolean[] isUsed = new boolean[10];
        while (sb.length() < ruleSet.getNumLen()) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (isUsed[num]) {
                continue;
            }
            sb.append(num);
            isUsed[num] = true;
        }

        return create(sb.toString(), ruleSet);
    }

    private static void validate(String value, RuleSet ruleSet) {
        if (value.length() != ruleSet.getNumLen()) {
            throw new IllegalArgumentException("길이가 " + ruleSet.getNumLen() + "이어야 합니다.");
        }
        if (!Pattern.matches("^[1-9]*$", value)) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 섞여있습니다.");
        }

        HashSet<Character> duplicateDetectorSet = new HashSet<>();
        for (int i = 0; i < ruleSet.getNumLen(); i++) {
            char num = value.charAt(i);
            if (duplicateDetectorSet.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
            }
            duplicateDetectorSet.add(num);
        }
    }

    public static MatchResult match(UniqueNumberString numberString1, UniqueNumberString numberString2) {
        if (numberString1.ruleSet != numberString2.ruleSet) {
            throw new RuntimeException("RuleSet이 달라 비교할 수 없습니다.");
        }

        RuleSet ruleSet = numberString1.ruleSet;
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < ruleSet.getNumLen(); i++) {
            for (int j = 0; j < ruleSet.getNumLen(); j++) {
                if (numberString1.value.charAt(i) != numberString2.value.charAt(j)) {
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

        return new MatchResult(ball, strike);
    }

    private UniqueNumberString(String value, RuleSet ruleSet) {
        this.value = value;
        this.ruleSet = ruleSet;
    }

    public String getValue() {
        return value;
    }

    public RuleSet getRuleSet() {
        return ruleSet;
    }

    @Override
    public int hashCode() {
        int result = ruleSet.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UniqueNumberString numberString)) {
            return false;
        }
        return numberString.ruleSet.equals(ruleSet) && numberString.value.equals(value);
    }

    @Override
    public String toString() {
        return "UniqueNumberString{" +
                "value='" + value + '\'' +
                ", ruleSet=" + ruleSet +
                '}';
    }
}
