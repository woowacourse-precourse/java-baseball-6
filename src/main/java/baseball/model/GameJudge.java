package baseball.model;

import java.util.List;

public class GameJudge {

    private final List<Integer> userNumber;
    private final List<Integer> computerNumber;

    private GameJudge(List<Integer> userNumber, List<Integer> computerNumber) {
        this.userNumber = userNumber;
        this.computerNumber = computerNumber;
    }

    public static GameJudge gameJudgeFactory(List<Integer> userNumber, List<Integer> computerNumber) {
        return new GameJudge(userNumber, computerNumber);
    }

    public GameResult judge() {
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

        return GameResult.gameResultFactory(strikeCount, ballCount);
    }

    private boolean isStrike(int index) {
        return userNumber.get(index).equals(computerNumber.get(index));
    }

    private boolean isBall(int index) {
        return computerNumber.contains(userNumber.get(index)) && !isStrike(index);
    }
}
