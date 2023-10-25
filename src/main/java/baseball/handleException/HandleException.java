package baseball.handleException;

import baseball.game.Constants;

public class HandleException {
    public static void exceptionHandlingForUserNumber(String userInput) {
        //정규표현식
        String regularExpForUserNumber = String.format("^(?!.*(.).*\\1)[1-9]{%d}$", Constants.GAME_NUMBER_SIZE);

        //예외처리
        if (!userInput.matches(regularExpForUserNumber)) {
            throw new IllegalArgumentException();


        }
    }

    public static void exceptionHandlingForUserInput(String userInput) {
        //정규표현식
        String regularExpForUserInput = "^[1-2]{1}$";

        //예외처리
        if (!userInput.matches(regularExpForUserInput)) {
            throw new IllegalArgumentException();

        }

    }
}
