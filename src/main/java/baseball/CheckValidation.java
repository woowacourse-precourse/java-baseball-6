package baseball;

import static baseball.Enum.END_PROGRAM;
import static baseball.Enum.INVALID_INPUT;

import java.util.HashSet;
import java.util.Set;


public class CheckValidation {

    public int checkAnswerValidation(String answer) {
        // 새로운 게임 시작
        if (answer.equals("1")) {
            return 1;
        }
        // 게임 종료
        if (answer.equals("2")) {
            System.out.println(END_PROGRAM.getMsg());
            return 2;
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMsg());
    }

    public void checkNumberValidation(String input) {
        // 문자열 배열로 치환
        String[] inputArr = input.split("");
        // 1. 입력값이 숫자인지 확인
        checkIfNumber(inputArr);
        // 2. 입력 길이 3인지 확인
        checkLength(inputArr);
        // 3. 중복값을 입력했는지 확인
        checkIfDuplicated(inputArr);
        return;
    }

    // 1. 입력값이 숫자인지 확인
    private void checkIfNumber(String[] inputArr) {
        String num = "123456789";
        for (String s : inputArr) {
            if (!num.contains(s)) {
                throw new IllegalArgumentException(INVALID_INPUT.getMsg());
            }
        }
        return;
    }

    // 2. 입력 길이 3인지 확인
    private void checkLength(String[] inputArr) {
        if (inputArr.length != 3) {
            throw new IllegalArgumentException(INVALID_INPUT.getMsg());
        }
        return;
    }

    // 3. 중복값을 입력했는지 확인
    private void checkIfDuplicated(String[] inputArr) {
        Set<String> set = new HashSet<>();
        for (String s : inputArr) {
            set.add(s);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT.getMsg());
        }
        return;
    }
}
