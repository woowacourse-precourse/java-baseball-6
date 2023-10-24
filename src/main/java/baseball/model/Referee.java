package baseball.model;

import baseball.model.dto.PlayerDto;
import baseball.model.dto.ResultDto;
import java.util.List;

public class Referee {

    private List<Integer> answer;

    private Boolean keepGoing = true;

    public Referee(List<Integer> answer) {
        this.answer = answer;
    }

    public Boolean keepGoing() {
        return keepGoing;
    }

    public ResultDto decidesResult(PlayerDto playerDto) {

    }

    private void isGameover(Integer strike) {
        if (strike == 3) {
            keepGoing = false;
        }
    }
}
