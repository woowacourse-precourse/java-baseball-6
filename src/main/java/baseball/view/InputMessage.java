package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {

    public String inputThreeNumber() {
        String threeNumber = Console.readLine();
        return threeNumber;
    }

    public String inputOptionNumber() {
        String menuNumber = Console.readLine();
        return menuNumber;
    }
}
