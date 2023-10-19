package baseball.Input;

public interface InputAnswer {

    Integer inputAnswer();

    void integrateValidation(String input);

    void isInteger(String input);

    void duplicateValidation(String input);

    void rangeValidation(String input);
}
