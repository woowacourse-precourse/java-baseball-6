package baseball.api.request;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RequestChecker {
    public static String gameRequest() throws IllegalArgumentException{
        String input = Console.readLine();
        inputCheck(input);
        return input;
    }

    public static String retryRequest(){
        return Console.readLine();
    }

    private static void inputCheck(String input) throws IllegalArgumentException{
        if (!isNumericAndThreeDigits(input)){
            throw new IllegalArgumentException("사용자의 입력값은 3자리 수이며 1-9까지의 값만 가능합니다.");
        } else if (!hasDuplicateDigits(input)) {
            throw new IllegalArgumentException("입력값은 중복되면 안됩니다.");
        }

    }
    //서로 다른 수 체크하기
    private static boolean isNumericAndThreeDigits(String input) {
        if (!Pattern.matches("^[1-9]{3}$",input)){
            return false;
        }
        return true;
    }

    //map 질문할 때마다 생성되니까 고려해보기
    private static boolean hasDuplicateDigits(String input){
        int length = input.chars()
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values()
                .size();

        return length == 3 ? true : false;
    }
}
