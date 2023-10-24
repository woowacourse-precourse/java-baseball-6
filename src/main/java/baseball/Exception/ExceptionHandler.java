package baseball.Exception;

// Player의 input exception을 검사하는 class
// 3자리 숫자와 restart 1자리 숫자에 대해 검사

import java.util.List;

public class ExceptionHandler {

    private static final int INPUTSIZE = 3;
    private static final int RESTART = 1;
    private static final int EXIT = 2;

    public ExceptionHandler() {
    }

    // 전체적으로 exception 검사를 실행하는 method
    // List type input을 매개변수로 각각의 검사를 실행
    public static void checkException(List<Integer> input) {

        checkNotNumber(input);
        checkDigit(input);
        checkDuplication(input);
    }

    // 3자리 숫자인지 검사하는 method
    // List type input을 매개변수로 검사를 수행
    private static void checkDigit(List<Integer> input) {

        if (input.size() != INPUTSIZE) {
            throw new IllegalArgumentException();
        }
    }

    // 숫자가 아닌 다른 문자인지 검사하는 method
    // List type input을 매개변수로 검사를 수행
    private static void checkNotNumber(List<Integer> input) {

        for (Integer num : input) {
            try {
                Integer.parseInt(String.valueOf(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 3자리 숫자중 중복된 숫자가 있는지 검사하는 method
    // List type input을 매개변수로 검사를 수행
    private static void checkDuplication(List<Integer> input) {

        for (int i = 0; i < 3; i++) {

            for (int j = i + 1; j < 2; j++) {

                isDuplicate(input.get(i), input.get(j));
            }
        }
    }

    // 3자리 숫자중 중복된 숫자가 있는지 직접적으로 계산하는 method
    // 이중 for문을 통한 'num1', 'num2'를 매개변수로 계산
    private static void isDuplicate(Integer num1, Integer num2) {

        if (num1.equals(num2)) {
            throw new IllegalArgumentException();
        }
    }

    // 재시작 여부를 묻는 input의 exception을 검사를 실행하는 method
    // String type ReInput을 매개변수로 Integer으로도 변환하여 검사를 실행
    // Integer type input을 반환
    public static Integer checkReNum(String ReInput) {

        Integer input = checkNotReNum(ReInput);
        checkReNum(input);
        return input;
    }

    // 재시작 여부를 묻는 input이 숫자인지 검사를 수행하는 method
    // String type input을 매개변수로 검사를 수행
    private static Integer checkNotReNum(String input) {

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 재시작 여부를 묻는 input이 2개의 숫자 중 일치하는지 검사하는 method
    // Integer type input을 매개변수로 검사를 수행
    private static void checkReNum(Integer input) {

        if (input != RESTART && input != EXIT) {
            throw new IllegalArgumentException();
        }
    }
}
