package baseball;

public class NumberValidate {
    public static Integer MAX_VALUE = 9;
    public static Integer MIN_VALUE = 1;
    public static boolean isInRange(int givenNumber) {
        return MIN_VALUE <= givenNumber && givenNumber <= MAX_VALUE ;
    }
}
