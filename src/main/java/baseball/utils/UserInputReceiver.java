package baseball.utils;

import baseball.constants.Constants;
import baseball.constants.Messages;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInputReceiver {
    public static void getUserGuessInput(List<Integer> generatedAnswers) {
        String userInput = null;
        do {
            System.out.print(Messages.ENTER_USER_INPUT);
            userInput = Console.readLine();
            Validator.validateUserInput(userInput);
            System.out.println(Judge.judgeScore(generatedAnswers, userInput));
        } while (!Judge.isCorrectAnswer(Convertor.listToString(generatedAnswers), userInput));
    }

    public static boolean getUserRestartInput() {
        System.out.println(Messages.GAME_CONTINUE_MESSAGE);
        String userInput = Console.readLine();

        Validator.validateRestartInput(userInput);

        if (userInput.equals(Constants.CODE_CONTINUE_GAME)) {
            return true;
        }
        return false;
    }
}
