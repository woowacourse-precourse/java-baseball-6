package baseball;

public class CheckRestartNum {
    static boolean isError(String restartString) {
        if (isNull(restartString)) {
            return (true);
        }
        return (!isCorrectLength(restartString) ||
                !isCorrectValue(restartString));
    }

    static boolean isNull(String restartString) {
        return (restartString == null);
    }

    static boolean isCorrectLength(String restartString) {
        return (restartString.length() == 1);
    }

    static boolean isCorrectValue(String restartString) {
        return (restartString.charAt(0) == '1' || restartString.charAt(0) == '2');
    }
}
