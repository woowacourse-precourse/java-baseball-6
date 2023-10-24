package baseball.io;

import baseball.constant.StringError;
import baseball.controller.BaseballGame;
import baseball.domain.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private Input() {
    }

    public static String stringNum() {

        String input = Console.readLine();

        if (Validator.isNull(input)) {
            Console.close();
            BaseballGame.exit(StringError.notInputError);

        } else if (!Validator.stringLengthCheck(input)) {
            Console.close();
            BaseballGame.exit(StringError.wrongLengthInputError);

        } else if (!Validator.isNumber(input)) {
            Console.close();
            BaseballGame.exit(StringError.wrongInputError);

        } else if (Validator.isDuplicate(input)) {
            Console.close();
            BaseballGame.exit(StringError.duplicatedInputError);
        }
        Console.close();

        return input;
    }

    public static String reStartOption() {

        String input = Console.readLine();

        if (!Validator.reStartChecker(input)) {
            Console.close();
            BaseballGame.exit(StringError.wrongInputError);
        }
        Console.close();

        return input;
    }
}
