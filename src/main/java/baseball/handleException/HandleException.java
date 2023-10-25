package baseball.handleException;

public class HandleException {
    public static void exceptionHandlingForUserNumber(String userInput) {
        //정규표현식
        String regularExpForUserNumber = "^(?!.*(.).*\\1)[1-9]{3}$";

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
