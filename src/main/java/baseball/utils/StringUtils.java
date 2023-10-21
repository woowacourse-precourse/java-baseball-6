package baseball.utils;

public class StringUtils {
    public static boolean hasDuplicateCharacters(String str) {
        return str.length() != str.chars().distinct().count();
    }
}
