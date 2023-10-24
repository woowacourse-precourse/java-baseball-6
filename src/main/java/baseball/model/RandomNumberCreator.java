package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class RandomNumberCreator {

    private String answer = "";

    public String getAnswer() {
        return answer;
    }

    public void setRandomNumber() {
        Set<Integer> generatedNumbers = new LinkedHashSet<>();
        int index = 0;

        while (index < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
                index++;
            }
        }

        StringBuilder generatedNumbersString = new StringBuilder();
        for (int num : generatedNumbers) {
            generatedNumbersString.append(num);
        }

        this.answer = generatedNumbersString.toString();
    }
}