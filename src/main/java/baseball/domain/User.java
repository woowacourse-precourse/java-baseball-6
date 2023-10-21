package baseball.domain;

import java.util.List;

public class User {

    private final InputOutputHandler inputOutputHandler;

    public User(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public List<Integer> guessAnswer(int numberLength) {
        List<Integer> guessNumberList = inputOutputHandler.inputUniqueNumbers(numberLength);
        return guessNumberList;
    }
}
