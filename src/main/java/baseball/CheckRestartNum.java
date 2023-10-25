package baseball;

public class CheckRestartNum {
    static boolean isError(String restartStr) {
        return (restartStr.length() != 1 ||
                (restartStr.charAt(0) != '1' &&
                        restartStr.charAt(0) != '2'));
    }
}
