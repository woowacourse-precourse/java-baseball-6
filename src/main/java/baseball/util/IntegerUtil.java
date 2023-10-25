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

    public static boolean isSame(Integer i1,Integer i2) {
        return ObjectUtil.isSame(i1,i2);
    }

    public static Integer parseInteger(char character){
        Integer integer = character - '0';

        return integer;
    }
}
