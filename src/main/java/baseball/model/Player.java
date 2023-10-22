package baseball.model;

import baseball.validation.PlayerValidation;

import java.util.List;

public class Player {

    private List<Integer> playerNumber;
    private Integer answerNumber;

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public Integer getAnswerNumber() {
        return answerNumber;
    }

    public void inputPlayerNumber(String numbers){
        playerNumber = PlayerValidation.checkNumber(numbers);
    }

    public void answerRestartOrEnd(String number){
        answerNumber = PlayerValidation.checkAnswerNumber(number);
    }
}
