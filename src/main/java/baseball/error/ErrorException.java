package baseball.error;

public interface ErrorException {
    String CHECK_NUMBER_STRING = "-?\\d+(\\.\\d+)?";
    void checkUserInputValidate(String checkNumber);

}
