package baseball;

import java.util.ArrayList;
import java.util.List;

public class GuessVo {
    private List guessedNumber;

    GuessVo(List<Integer> numberList){
        guessedNumber = new ArrayList(numberList);
    }

    public List getGuessedNumber(){
        return new ArrayList(guessedNumber);
    }
}
