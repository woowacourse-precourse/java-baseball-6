package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> inputAnswer;

    public void insertInputAnswer(String stringInputAnswer) {
        this.inputAnswer = convertStringInputToIntegerList(stringInputAnswer);
    }

    public List<Integer> getInputAnswer() {
        return inputAnswer;
    }

    private List<Integer> convertStringInputToIntegerList(String stringInput) {
        List<Integer> integerList = new ArrayList<>();

        for (char c : stringInput.toCharArray()) {
            integerList.add(Character.getNumericValue(c));
        }

        return integerList;
    }
}