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


}
