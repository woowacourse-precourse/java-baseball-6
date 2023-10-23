package baseball.model;

import baseball.GameOption;
import baseball.Validator;
import java.util.List;
import java.util.Objects;

public record Computer(List<Integer> answer) {

    public Computer {
        Validator.validatedBaseballNumber(answer);
    }

    public List<Integer> calculateResult(List<Integer> trial) {
        int ballCount = 0;
        int strikeCount = 0;
        for (int i = 0; i < GameOption.BASEBALL_SIZE; i++) {
            Integer current = trial.get(i);
            if (answer.contains(current)) {
                if (Objects.equals(answer.get(i), current)) {
                    strikeCount++;
                    continue;
                }
                ballCount++;
            }
        }
        return List.of(ballCount, strikeCount);
    }
}
