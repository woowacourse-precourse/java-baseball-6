package baseball;

import static baseball.Enum.END_PROGRAM;
import static baseball.Enum.INVALID_INPUT;

import java.util.HashSet;
import java.util.Set;


public class CheckValidation {

    public int checkAnswerValidation(String answer) {

        if (answer.equals("1")) { // 새로운 게임 시작
            return 1;
        }
        if (answer.equals("2")) { // 게임 종료
            System.out.println(END_PROGRAM.getMessage());
            return 2;
        }
        // 유효하지 않은 입력
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

    public void checkNumberValidation(String input) {
        // 문자열 배열로 치환
        String[] inputArr = input.split("");
        checkIfNumber(inputArr);
        checkLength(inputArr);
        checkIfDuplicated(inputArr);
        return;
    }

    // 입력값이 숫자인지 확인
    private void checkIfNumber(String[] strArr) {
        String num = "123456789";
        for (String s : strArr) {
            if (!num.contains(s)) {
                throw new IllegalArgumentException(INVALID_INPUT.getMessage());
            }
        }
        return;
    }

    // 입력 길이 3인지 확인
    private void checkLength(String[] strArr) {
        if (strArr.length != 3) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        return;
    }

    // 중복값을 입력했는지 확인
    private void checkIfDuplicated(String[] strArr) {
        Set<String> set = new HashSet<>();
        for (String s : strArr) {
            set.add(s);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
        return;
    }
}
