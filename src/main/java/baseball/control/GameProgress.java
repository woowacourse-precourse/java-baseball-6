package baseball.control;

import baseball.domain.Judge;

import java.util.List;

public class GameProgress {
    private Judge judge;

    public GameProgress() {
        judge = new Judge();
    }

    public String getHintOfJudge(List<Integer> computerList, List<Integer> userList) {
        return judge.CheckProgressBaseballGame(computerList, userList);
    }
}
