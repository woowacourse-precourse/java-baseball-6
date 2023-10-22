package baseball.model;

import java.util.List;

public class GameScore {

    private final List<Integer> userNumber;
    private final List<Integer> computerNumber;

    private GameScore(List<Integer> userNumber, List<Integer> computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }

    public void judge() {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (isStrike(i)) {
                strikeCount++;
                continue;
            }
            if (isBall(i)) {
                ballCount++;
            }
        }

        // todo 볼과 스트라이크 카운트로 결과를 정할 객체 필요
    }

    private boolean isStrike(int index) {
        return userNumber.get(index).equals(computerNumber.get(index));
    }

    private boolean isBall(int index) {
        return computerNumber.contains(userNumber.get(index)) && !isStrike(index);
    }
}
