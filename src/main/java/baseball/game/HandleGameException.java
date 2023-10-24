package baseball.game;

import java.util.List;

public class HandleGameException {

    public static void askingUserInputException(String userInput)  {
        //정규표현식}
        String regularExpForUserNumber = "^(?!.*(.).*\\1)[1-9]{3}$";

        //예외처리
        if (!userInput.matches(regularExpForUserNumber)) {
            throw new IllegalArgumentException();


        }
    }
}
