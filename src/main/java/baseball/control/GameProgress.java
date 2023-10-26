package baseball.control;

import baseball.domain.Judge;
import baseball.domain.NumbersGenerate;

import java.util.List;

public class GameProgress {
    private Judge judge;
    private NumbersGenerate numbersGenerate;

    public GameProgress() {
        judge = new Judge();
        numbersGenerate = new NumbersGenerate();
    }

    public String getHintOfJudge(List<Integer> computerList, List<Integer> userList) {
        return judge.CheckProgressBaseballGame(computerList, userList);
    }

    public List<Integer> makeComputerList() {
        return numbersGenerate.createRandomNumList();
    }
}
