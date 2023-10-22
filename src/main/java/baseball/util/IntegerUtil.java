package baseball.util;

public class IntegerUtil {

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static Integer parseInteger(char character){
        Integer integer = character - '0';

        return integer;
    }
}
