package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {

    private final InputValidation inputValidation = new InputValidation();

    public String inputThreeNumber() {
        String threeNumber = Console.readLine();
        inputValidation.validateNumber(threeNumber);
        return threeNumber;
    }

    public String inputMenuNumber() {
        String menuNumber = Console.readLine();
        inputValidation.validateMenuNumber(menuNumber);
        return menuNumber;
    }
}
