package baseball;

import java.util.HashSet;
import java.util.Set;


public class CheckValidation {
    private String input;

    CheckValidation(String input) {
        this.input = input;
    }

    public int checkAnswerValidation(String str) {
        // 빈 칸 제거
        str.replaceAll(" ", "");
        if (str.equals("1")) {
            return 1;
        }
        if (str.equals("2")) {
            return 2;
        } else {
            System.out.println("1 또는 2만 입력할 수 있습니다.");
            return -1;
        }
    }

    public String checkNumberValidation() {
        // 빈 칸 제거
        input.replaceAll(" ", "");
        // 문자열 배열로 치환
        String[] inputArr = input.split("");

        if (checkIfNumber(inputArr) == false) {
            return "문자, 특수문자, 공백이 아닌 숫자만 입력해주세요.";
        }
        if (checkLength(inputArr) == false) {
            return "3자리의 숫자만 입력해주세요.";
        }
        if (checkIfDuplicated(inputArr) == false) {
            return "중복되지 않는 숫자로 이루어진 3자리 수를 입력해주세요.";
        }
        return "유효";
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
