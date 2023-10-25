package baseball.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public final class Answer {
    public static final int ANSWER_LENGTH = 3;

    private List<Integer> numberList;

    public Answer() {
        this.numberList = generateNumbersForBaseball();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void resetAnswer() {
        this.numberList = generateNumbersForBaseball();
    }

    private List<Integer> generateNumbersForBaseball() {
        List<Integer> generatedNumbers = new ArrayList<>();
        
        while (generatedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
            }
        }

        return generatedNumbers;
    }
}
