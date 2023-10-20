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
        for (int num : Randoms.pickUniqueNumbersInRange(1, 9, ruleSet.getNumLen())) {
            sb.append(num);
        }

        return new UniqueNumberString(sb.toString(), ruleSet);
    }

    private static void validate(String value, RuleSet ruleSet) {
        boolean isNumberMatchesLength = Pattern.matches("^[1-9]{" + ruleSet.getNumLen() + "}$", value);
        if (!isNumberMatchesLength) {
            throw new IllegalArgumentException("길이가 " + ruleSet.getNumLen() + "이어야 합니다.");
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
    public String toString() {
        return "UniqueNumberString{" +
                "value='" + value + '\'' +
                ", ruleSet=" + ruleSet +
                '}';
    }
}
