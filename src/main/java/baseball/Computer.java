package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final String answerNumbers;

    Computer() {
        List<Integer> generatedNumbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (generatedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) {
                sb.append(generatedNumbers);
                generatedNumbers.add(randomNumber);
            }
        }
        this.answerNumbers = sb.toString();
    }

    public String getAnswerNumbers() {
        return answerNumbers;
    }
}