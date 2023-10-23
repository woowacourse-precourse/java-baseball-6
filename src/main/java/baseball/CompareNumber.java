package baseball;

import java.util.List;

public class CompareNumber {
    int ball;
    int strike;

    public void countBall(List<String> user, List<String> computer) {
        for (int i = 0; i < user.size(); i++) {
            if (computer.contains(user.get(i))) {
                ball++;
            }
        }
    }
}
