package baseball.engine.manager;

import baseball.engine.dto.Status;
import java.util.List;

public class Referee {

    public Referee() {
    }

    public Status judge(List<Integer> userNumbers, List<Integer> randomNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            int userNumber = userNumbers.get(i);
            int randomNumber = randomNumbers.get(i);

            if (userNumber == randomNumber) {
                strike++;
            } else if (randomNumbers.contains(userNumber)) {
                ball++;
            }
        }

        return new Status(strike, ball);
    }
}
