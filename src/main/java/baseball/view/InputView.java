package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int INPUT_LENGTH = 3;
    private static final String SEPARATOR = "";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static List<String> readPlayerNumber() {
        System.out.print(INPUT_MESSAGE);
        String[] input = Console.readLine().split(SEPARATOR);
        List<String> inputList = Arrays.asList(input);
        validation(inputList);
        return inputList;
    }

    private static void validation(List<String> input) {
        validationLength(input);
        validationNumeric(input);
        checkDuplicate(input);
    }

    private static void validationLength(List<String> input) {
        if (input.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validationNumeric(List<String> input) {
        for (String string : input) {
            checkNumeric(string);
        }
    }

    private static void checkNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicate(List<String> input) {
        List<String> list = input
            .stream()
            .distinct()
            .toList();
        if (list.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static int readEndSign() {
        System.out.println(RESTART_MESSAGE);
        String endSign = Console.readLine();
        return validationEndSign(endSign);
    }
    private static int validationEndSign(String endSign){
        checkNumeric(endSign);
        int integerEndsign = Integer.parseInt(endSign);
        checkEndSignRange(integerEndsign);
        return integerEndsign;
    }
    private static void checkEndSignRange(int sign){
        if(sign > 2){
            throw new IllegalArgumentException();
        }
    }
}
