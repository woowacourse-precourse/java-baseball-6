package baseball.checker;

import java.util.regex.Pattern;

// 사용자가 입력한 값의 유효성을 판단하기 위한 클래스
public class InputValueChecker {
    private final static String REGEXP_PATTERN_NUMBER = "\\d{3}"; // 서로 다른 3자리의 수
    private final static String REGEXP_PATTERN_SIGNAL = "[1, 2]"; // 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

    // 사용자가 게임하는 과정에서 유효하지 않은 값을 입력하는 경우, 오류 반환
    public static void checkNumberValidation(String inputValue) {
        if(!Pattern.matches(REGEXP_PATTERN_NUMBER, inputValue) ||
                !checkDuplication(inputValue) ||
                inputValue.startsWith("0"))
            throw new IllegalArgumentException();
    }

    // 사용자가 게임을 계속하길 원하면 1, 종료하려면 2를 입력하는데, 1, 2를 제외한 값이 입력되는 경우 오류 반환
    public static void checkSignalValidation(String userSignal) {
        if(!Pattern.matches(REGEXP_PATTERN_SIGNAL, userSignal))
            throw new IllegalArgumentException();
    }

    // 중복여부 확인
    public static boolean checkDuplication(String value) {
        String rmDpNumber = "";

        for(String word : value.split("")) {
            if(!rmDpNumber.contains(word)) rmDpNumber += word;
        }

        return rmDpNumber.equals(value);
    }

    private InputValueChecker() {
    }
}
