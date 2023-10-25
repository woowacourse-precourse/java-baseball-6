package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Common {
    public static List<Integer> stringToIntegerArray(String inputString) {
        return Arrays.stream(inputString.split(""))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }
    public static String input3StringFromKeyboard() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputString = Console.readLine();
        HandleError.validateInputStringIsNumber(inputString);
        HandleError.validateInputStringSize(inputString,3);

        return inputString;
    }
    public static String input1StringFromKeyboard() {
        String inputString = Console.readLine();
        HandleError.validateInputStringIsNumber(inputString);
        HandleError.validateInputStringSize(inputString,1);
        return inputString;
    }
}
