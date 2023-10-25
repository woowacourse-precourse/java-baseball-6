package baseball.Utils;

import java.util.ArrayList;
import java.util.List;

public class ExceptionProcess {
    // 사용자 입력 예외처리
    public void allUserException(String input) {
        inputLengthExceededException(input); // 입력값 길이 초과
        nonNumericInputException(input); // 숫자가 아닌 문자를 입력한 경우
        duplicateNumberException(input); // 입력값 중복
        invalidNumberException(input); // 입력값 1 ~ 9 해당
    }

    // 재시작/종료 여부를 입력할 때
    public void enterRestartAndExitException(String choice) {
        nonNumericInputException(choice); // 숫자가 아닌 문자를 입력한 경우
        invalidChoiceException(choice); // 1 or 2를 입력한 경우

    }

    // 1. 숫자가 아닌 문자를 입력한 경우
    public void nonNumericInputException(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    // 2. 숫자를 3개 초과로 입력한 경우
    public void inputLengthExceededException(String input) {
        if (input.length() > 3) {
            throw new IllegalArgumentException("숫자는 3개만 입력해 주세요.");
        }
    }

    // 3. 중복이 존재하는 경우
    public void duplicateNumberException(String input) {
        List<Integer> user = new ArrayList<>();
        String[] userInput = input.split("");
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(userInput[i]);
            if (user.contains(num)) {
                throw new IllegalArgumentException("숫자 중복은 허용되지 않습니다.");
            }
            user.add(num);
        }
    }

    // 4. 1 ~ 9에 해당하지 않는 수가 있는 경우
    public void invalidNumberException(String input) {
        String[] userInput = input.split("");
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(userInput[i]);
            if (num < 1 || num > 9) throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해 주세요. ");
        }
    }

    // 1. 숫자가 아닌 문자를 입력한 경우
    // 사용자 1번 예외처리와 동일
    // 2. 1 or 2를 제외한 수를 입력한 경우
    public void invalidChoiceException(String choice) {
        if (!choice.equals("1") && !choice.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
