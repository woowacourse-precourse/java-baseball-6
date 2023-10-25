package baseball;

public class CheckRestartNum {
    static boolean isError(String restartString) {
        if (Util.isNull(restartString)) {
            return (true);
        }
        return (!Util.isCorrectLength(restartString, 1) ||
                !isCorrectValue(restartString));
    }

    static boolean isCorrectValue(String restartString) {
        return (restartString.charAt(0) == '1' || restartString.charAt(0) == '2');
    }
}
