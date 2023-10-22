package baseball;

import java.util.List;

public class ScoreBoard {

    private final List<String> scoreBoardList;

    public ScoreBoard(List<String> scoreBoardList) {
        this.scoreBoardList = scoreBoardList;
    }

    public int countStrike() {
        return (int) scoreBoardList.stream()
                .filter(e -> e.equals("STRIKE"))
                .count();
    }

    public int countBall() {
        return (int) scoreBoardList.stream()
                .filter(e -> e.equals("BALL"))
                .count();
    }

    public boolean isNothing() {
        if ((int) scoreBoardList.stream()
                .filter(e -> e.equals("NOTHING"))
                .count() == scoreBoardList.size()) {
            return true;
        }
        return false;
    }

    public boolean isThreeStrike() {
        if (countStrike() == scoreBoardList.size()){
            return true;
        }
        return false;
    }
}
