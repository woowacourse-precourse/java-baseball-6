package baseball;

import java.util.HashSet;
import java.util.Set;


public class CheckValidation {
    private String input;

    CheckValidation(String input) {
        this.input = input;
    }

    public int checkAnswerValidation(String s) {

        if (s.equals("1")) { // 새로운 게임 시작
            return 1;
        }
        if (s.equals("2")) { // 게임 종료
            System.out.println("프로그램이 완전히 종료되었습니다. 게임을 하고 싶으면 다시실행 해주세요.");
            return 2;
        }
        // 유효하지 않은 입력
        throw new IllegalArgumentException("유효하지 않은 값을 입력했습니다. 프로그램이 종료됩니다.");
    }

    public void checkNumberValidation() {
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
                throw new IllegalArgumentException("유효하지 않은 값을 입력했습니다. 프로그램이 종료됩니다.");
            }
        }
        return;
    }

    // 입력 길이 3인지 확인
    private void checkLength(String[] strArr) {
        if (strArr.length != 3) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력했습니다. 프로그램이 종료됩니다.");
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
            throw new IllegalArgumentException("유효하지 않은 값을 입력했습니다. 프로그램이 종료됩니다.");
        }
        return;
    }
}
