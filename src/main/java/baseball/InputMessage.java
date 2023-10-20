package baseball;

import camp.nextstep.edu.missionutils.Console;
public class InputMessage {

    private final InputValidation inputValidation = new InputValidation();
    public String inputThreeNumber() {
        String threeNumber = Console.readLine();
        inputValidation.isThreeNumber(threeNumber);
        return threeNumber;
    }

    public boolean inputMenuNumber() {
        String menuNumber = Console.readLine();
        inputValidation.isMenuNumber(menuNumber);
        if (Integer.parseInt(menuNumber) == 1)
            return true;
        return false;
    }
}
