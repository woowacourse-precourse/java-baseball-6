package baseball.domain;

import java.util.List;

public class Me {

    private final InputOutputHandler inputOutputHandler;

    public Me(InputOutputHandler inputOutputHandler) {
        this.inputOutputHandler = inputOutputHandler;
    }

    public List<Integer> guessAnswer(int numberLength) {
        List<Integer> guessNumberList = inputOutputHandler.inputUniqueNumbers(numberLength);
        return guessNumberList;
    }
}
