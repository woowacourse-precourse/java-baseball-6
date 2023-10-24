package baseball.utills;

public class ValidateUtils {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    public static boolean validNo(int givenNumber) {
        return givenNumber >= MIN_VALUE && givenNumber <= MAX_VALUE;
    }
}
