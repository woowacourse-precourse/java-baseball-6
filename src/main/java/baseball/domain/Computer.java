package baseball.domain;

import baseball.constant.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final String numbers;

    public Computer() {
        this.numbers = generateNumber();
    }

    private String generateNumber() {
        List<Integer> generatedNumbers = new ArrayList<>();
        while (generatedNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedNumbers.contains(randomNumber)) generatedNumbers.add(randomNumber);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : generatedNumbers) sb.append(num);

        return sb.toString();
    }

    public String getNumbers() {
        return numbers;
    }
}