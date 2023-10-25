package baseball;

public class Util {
    static boolean isNull(String baseballNum) {
        return (baseballNum == null);
    }

    static boolean isCorrectLength(String inputString, int len) {
        return (inputString.length() == len);
    }
}
