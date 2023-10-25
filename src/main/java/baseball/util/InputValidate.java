package baseball.util;

import baseball.util.GameConstant;
import java.util.HashSet;
import java.util.Set;

public class InputValidate {

    public static int checkInputNumber (String aNumber) {
        if (isNumberValue(aNumber) && isUniqueValue(aNumber)) {
            return Integer.parseInt(aNumber);
        } throw new IllegalArgumentException();
    }

    public static int checkCommand (int aCommand) {
        if (isCommand(aCommand)) {
            return aCommand;
        } throw new IllegalArgumentException();
    }


    private static boolean isNumberValue (String aNumber) {
        return aNumber.matches(GameConstant.REGEX);
    }
    private static boolean isUniqueValue (String aNumber) {
        Set<Character> set = new HashSet<>();
        for (char number : aNumber.toCharArray()) {
            set.add(number);
        }
        return set.size() == GameConstant.LENGTH;
    }

    private static boolean isCommand (int aCommand) {
        return (aCommand == GameConstant.RETRY_COMMAND || aCommand == GameConstant.FINISH_COMMAND);
    }
}
