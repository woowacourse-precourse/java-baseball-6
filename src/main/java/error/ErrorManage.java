package error;

import java.util.HashSet;

public class ErrorManage {
    public void inputNumberErrorManage(String input) {
        if (isCorrectLength(input)) {
            throw new IllegalArgumentException("{input number} :input의 길이가 이상합니다.");
        }
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("{input number} : 숫자가 아닌 문자가 포함되어 있습니다.");
        }
        if (!hasUniqueDigits(input)) {
            throw new IllegalArgumentException("{input number} : 숫자가 서로 다르지 않습니다.");
        }
    }

    public void exitNumberErrorManage(String input) {
        if (isCorrectLength(input)) {
            throw new IllegalArgumentException("{exit number} : input의 길이가 이상합니다.");
        }
        if (is1or2(input)) {
            throw new IllegalArgumentException("{exit number} : 제대로 된 input값이 아닙니다.");
        }

    }

    private boolean is1or2(String str) {
        return (!str.equals("1") && !str.equals("2"));
    }

    private boolean isCorrectLength(String str) {
        return (str.length() != 3 && str.length() != 1);
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    private boolean hasUniqueDigits(String str) {
        HashSet<Character> uniqueDigits = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (uniqueDigits.contains(c)) {
                return false;
            }
            uniqueDigits.add(c);
        }
        return true;
    }
}
