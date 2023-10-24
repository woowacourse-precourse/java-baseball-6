package baseball.domain;

import java.util.List;

public class GameResult {

    private int ballNumber;
    private int strikeNumber;

    public GameResult() {
        this.ballNumber=0;
        this.strikeNumber=0;
    }

    public List<Integer> calculateResult(List<Integer> com, List<Integer> user) {
        int i=0;
        for(i=0; i<user.size(); i++) {
            if (com.contains(user.get(i))) {
                if (com.get(i).equals(user.get(i))) {
                    this.strikeNumber++;
                } else {
                    this.ballNumber++;
                }
            }
        }
        return List.of(this.ballNumber, this.strikeNumber);
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }
}
