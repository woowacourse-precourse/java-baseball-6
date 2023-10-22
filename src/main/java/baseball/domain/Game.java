package baseball.domain;

import baseball.constant.Validation;
import baseball.dto.ScoreDto;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private final List<Integer> targets;

    public Game() {
        this.targets = new ArrayList<>();
        while (this.targets.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.targets.contains(randomNumber)) {
                this.targets.add(randomNumber);
            }
        }
    }

    public ScoreDto compareWithTarget(List<Integer> inputs) {
        if (!isValidInput(inputs)) {
            throw new IllegalArgumentException();
        }
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < Validation.NUMBER_LENGTH; i++) {
            if (this.targets.get(i).equals(inputs.get(i))) {
                strike = strike + 1;
                continue;
            }
            if (this.targets.contains(inputs.get(i))) {
                ball = ball + 1;
            }
        }
        return new ScoreDto(strike, ball);
    }

    private boolean isValidInput(List<Integer> inputs) {
        if (inputs.size() != Validation.NUMBER_LENGTH) {
            return false;
        }
        if (inputs.stream().anyMatch(number -> Validation.MIN_NUMBER > number
                | Validation.MAX_NUMBER < number)) {
            return false;
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean isDuplicates = inputs.stream()
                .anyMatch(number -> !uniqueNumbers.add(number));

        return !isDuplicates;
    }
}
