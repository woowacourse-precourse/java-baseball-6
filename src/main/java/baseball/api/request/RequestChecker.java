package baseball.api.request;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RequestChecker {
    private static final int NUMBER_LENGTH = 3;

    public static String gameRequest() throws IllegalArgumentException{
        String input = Console.readLine();
        validateUserInput(input);
        return input;
    }

    private static void validateUserInput(String input) throws IllegalArgumentException{
        if (!isNumericAndThreeDigits(input)){
            throw new IllegalArgumentException("사용자의 입력값은 3자리 수이며 1-9까지의 값만 가능합니다.");
        } else if (!hasDuplicateDigits(input)) {
            throw new IllegalArgumentException("입력값은 중복되면 안됩니다.");
        }
    }

    private static boolean isNumericAndThreeDigits(String input) {
        if (Pattern.matches("^[1-9]{3}$",input)){
            return true;
        }
        return false;
    }

    private static boolean hasDuplicateDigits(String input){
        int length = input.chars()
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toSet())
                .size();

        return length == NUMBER_LENGTH ? true : false;
    }

    public static String retryRequest(){
        return Console.readLine();
    }
}
