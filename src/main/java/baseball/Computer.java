package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> comNumber;

    public Computer() {
        comNumber = new ArrayList<>();
        while (comNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNumber.contains(randomNumber)) {
                comNumber.add(randomNumber);
            }
        }
    }

    public String playGame(List<Integer> userNumber) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i = 0; i < comNumber.size(); i++) {
            if (comNumber.get(i).equals(userNumber.get(i))) {
                strikeCount++;
            } else if (userNumber.contains(comNumber.get(i))) {
                ballCount++;
            }
        }

        if (strikeCount != 0 && ballCount != 0) {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        } else if (strikeCount != 0) {
            return strikeCount + "스트라이크";
        } else if (ballCount != 0) {
            return ballCount + "볼";
        }
        return "낫싱";
    }
}
