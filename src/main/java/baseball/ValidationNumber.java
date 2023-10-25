package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidationNumber {
    private static final String CHECK_NUMBER = "숫자만 입력해주세요.";
    private static final String CHECK_LENGTH = "3자리 수를 입력해주세요.";
    private static final String CHECK_ZERO = "1~9의 수만 입력해주세요.";
    private static final String DUPLICATE = "서로 다른 3개의 수를 입력해주세요.";
    private static final String VALID_NUMBER = "1 혹은 2만 입력해주세요.";

    public static void checkNumber(String inputNumber){
        try{
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(CHECK_NUMBER);
        }
    }

    public static void checkLength(List<Integer> player){
        if (player.size() != 3){
            throw new IllegalArgumentException(CHECK_LENGTH);
        }
    }

    public static void checkZero(List<Integer> player){
        if (player.contains(0)){
            throw new IllegalArgumentException(CHECK_ZERO);
        }
    }

    public static void duplicateNumber(List<Integer> player){
        Set<Integer> set = new HashSet<Integer>(player);
        if (set.size() != 3){
            throw new IllegalArgumentException(DUPLICATE);
        }
    }

    public static void validNumber(int number){
        if (number != 1 && number != 2){
            throw new IllegalArgumentException(VALID_NUMBER);
        }
    }
}
