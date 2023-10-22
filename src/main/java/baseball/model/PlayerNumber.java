package baseball.model;

import java.util.ArrayList;
import java.util.List;
import baseball.validator.NumberCheck;

public class PlayerNumber {

    private List<Integer> playerNumber = new ArrayList<>();

    public PlayerNumber(String input){
        NumberCheck.DuplicateNumber(input);
        NumberCheck.NonNumber(input);
        NumberCheck.DigitNumber(input);
        NumberCheck.RangeOut(input);

        for(String number: input.split("")){
            this.playerNumber.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getPlayerNumber(){
        return playerNumber;
    }
}
