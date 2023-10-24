package baseball.service;

import baseball.constants.Baseball;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final ScoreService scoreService;
    private Boolean isRoundEnd;


    public GameService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public void init() {
        this.isRoundEnd = false;
    }

    public Result playRound(List<Integer> answer, List<Integer> userInput) {
        return new Result(scoreService.getStrikes(answer, userInput), scoreService.getBalls(answer, userInput));
    }

    public List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < Baseball.MAX_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(Baseball.MIN_NUMBER.getValue(), Baseball.MAX_NUMBER.getValue());
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public boolean isWin(Result result) {
        return result.getStrike() == Baseball.GOAL.getValue();
    }

    public boolean isRoundEnd() {
        return isRoundEnd;
    }

    public void setRoundEnd() {
        this.isRoundEnd = true;
    }
}
