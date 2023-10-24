package baseball.validation;

import baseball.error.CheckerForUnvalidCharOfSelection;
import baseball.error.CheckerForUnvalidLengthOfSelection;
import baseball.error.CheckerForUnvalidRangeOfSelection;

public class ValidGameContinueMode {
    public void validateInputOfGameContinueSelection(String gameContinueSelection) {
        try {
            new CheckerForUnvalidLengthOfSelection().check(gameContinueSelection);
            new CheckerForUnvalidCharOfSelection().check(gameContinueSelection);
            new CheckerForUnvalidRangeOfSelection().check(gameContinueSelection);
        }
        catch(IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
    }
}
