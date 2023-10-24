package baseball;

import java.util.List;

public class BaseballGame {

    private List<Integer> computerNumber;

    public Score computeUserScore(List<Integer> userNumber){
        return Referee.makeScore(userNumber, computerNumber);
    }

    public void initComputerNumber(){
        computerNumber = RandomNumGenerator.generateComputerRandomThreeDigitNumber();
    }


}
