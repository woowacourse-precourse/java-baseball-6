package baseball;

import static baseball.GameOption.BASEBALL_END_NUMBER;
import static baseball.GameOption.BASEBALL_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
    private List<Integer> answer;

    public Computer() {
        answer = new ArrayList<>();
        while (answer.size() < GameOption.BASEBALL_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(BASEBALL_START_NUMBER, BASEBALL_END_NUMBER);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
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
