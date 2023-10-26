package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public record Player() {
    private static final List<Integer> inputAnswer = new ArrayList<>();

    public void insertInputAnswer(final String stringInputAnswer) {
        inputAnswer.clear();
        convertStringInputToIntegerList(stringInputAnswer);
    }

    public List<Integer> getInputAnswer() {
        return inputAnswer;
    }

    private void convertStringInputToIntegerList(String stringInput) {
        for (char c : stringInput.toCharArray()) {
            inputAnswer.add(Character.getNumericValue(c));
        }
    }
}