package baseball.error;

import baseball.massage.ErrorMassage;

public class ChoiceError {
    public static void checkChoiceNumber(String input){
        if(!(input.equals("1") || !(input.equals("2")))){
            throw new IllegalArgumentException(ErrorMassage.ONLY_ONE_OR_TWO.getErrorMessage());
        }
    }
}
