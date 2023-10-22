package baseball.model;

import java.util.List;

public class GameRound {

    private final List<Integer> userList;
    private final List<Integer> computerList;

    private GameRound(List<Integer> userList, List<Integer> computerList) {
        this.userList = userList;
        this.computerList = computerList;
    }

    public static GameRound gameProcessFactory(List<Integer> userList, List<Integer> computerList) {
        return new GameRound(userList, computerList);
    }

    public String choose() {
        GameJudge gameJudge = GameJudge.gameJudgeFactory(userList, computerList);
        GameResult result = gameJudge.judge();
        return result.resultString();
    }

}
