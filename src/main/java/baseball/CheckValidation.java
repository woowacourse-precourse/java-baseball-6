package baseball;

import static baseball.Enum.LETTER_ERROR;
import static baseball.Enum.LIMIT_THREE_NUMBER;
import static baseball.Enum.NOT_DUPLICATED;
import static baseball.Enum.VALID;
import static baseball.Enum.VALID_ANSWER;

import java.util.HashSet;
import java.util.Set;


public class CheckValidation {
    private String input;

    CheckValidation(String input) {
        this.input = input.trim();
    }

    public int checkAnswerValidation(String s) {
        s = s.trim();
        if (s.equals("1")) {
            return 1;
        }
        if (s.equals("2")) {
            return 2;
        } else {
            System.out.println(VALID_ANSWER);
            return -1;
        }
    }

    public Enum checkNumberValidation() {
        // 문자열 배열로 치환
        String[] inputArr = input.split("");
        if (checkIfNumber(inputArr) == false) {
            return LETTER_ERROR;
        }
        if (checkLength(inputArr) == false) {
            return LIMIT_THREE_NUMBER;
        }
        if (checkIfDuplicated(inputArr) == false) {
            return NOT_DUPLICATED;
        }
        return VALID;
    }

    // 입력값이 숫자인지 확인
    private boolean checkIfNumber(String[] strArr) {
        String num = "0123456789";
        for (String s : strArr) {
            if (!num.contains(s)) {
                return false;
            }
        }
        return true;
    }

    // 입력 길이 3인지 확인
    private boolean checkLength(String[] strArr) {
        if (strArr.length != 3) {
            return false;
        }
        return true;
    }

    // 중복값을 입력했는지 확인
    private boolean checkIfDuplicated(String[] strArr) {
        Set<String> set = new HashSet<>();
        for (String s : strArr) {
            set.add(s);
        }
        if (set.size() != 3) {
            return false;
        }
        return true;
    }
}
