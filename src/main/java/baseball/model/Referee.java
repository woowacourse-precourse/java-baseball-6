package baseball.model;

import baseball.constant.GameConstant;
import baseball.model.dto.PlayerDto;
import baseball.model.dto.ResultDto;
import java.util.List;

public class Referee {

    private final List<Integer> answer;
    private Boolean keepGoing = true;

    public Referee(List<Integer> answer) {
        this.answer = answer;
    }

    public Boolean keepGoing() {
        return keepGoing;
    }

    public ResultDto decidesResult(PlayerDto playerDto) {
        List<Integer> playerInputList = playerDto.getInputList();
        Integer strike = 0;
        Integer ball = 0;

        for (int i = 0; i < GameConstant.GAME_NUMBER_LENGTH; i++) {
            Integer answerNumber = answer.get(i);
            Integer playerNumber = playerInputList.get(i);

            if (answerNumber.equals(playerNumber)) {
                strike++;
            } else if (answer.contains(playerNumber)) {
                ball++;
            }
        }

        isGameover(strike);
        return new ResultDto(strike, ball);
    }

    private void isGameover(Integer strike) {
        if (strike == 3) {
            keepGoing = false;
        }
    }
}