package baseball.error;

public interface ErrorException {
    final static String CHECK_NUMBER_STRING = "-?\\d+(\\.\\d+)?";
    void checkUserInputValidate(String checkNumber);

}
