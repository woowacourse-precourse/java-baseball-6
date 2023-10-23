package baseball.view;

import baseball.validator.BaseballNumberInputValidation;
import baseball.validator.NewGameOrEndInputValidation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final BaseballNumberInputValidation baseballNumberInputValidation;
    private final NewGameOrEndInputValidation newGameOrEndInputValidation;

    public InputView(
            BaseballNumberInputValidation baseballNumberInputValidation,
            NewGameOrEndInputValidation newGameOrEndInputValidation
    ) {
        this.baseballNumberInputValidation = baseballNumberInputValidation;
        this.newGameOrEndInputValidation = newGameOrEndInputValidation;
    }

    public String askForNumber() {
        String input = Console.readLine();
        baseballNumberInputValidation.validate(input);
        return input;
    }

    public int askForNewGameOrEnd() {
        String input = Console.readLine();
        newGameOrEndInputValidation.validate(input);
        return Integer.parseInt(input);
    }
}
