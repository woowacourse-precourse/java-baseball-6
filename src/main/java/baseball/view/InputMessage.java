package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {

    private final InputValidation inputValidation = new InputValidation();

    public String inputThreeNumber() {
        String threeNumber = Console.readLine();
        return threeNumber;
    }

    public String inputOptionNumber() {
        String menuNumber = Console.readLine();
        return menuNumber;
    }
}
