package baseball.Input;

import java.util.List;

public interface InputAnswer {

    List<Integer> inputAnswer();

    void integrateValidation(String input);

    void isInteger(String input);

    void duplicateValidation(String input);

    void rangeValidation(String input);
}
