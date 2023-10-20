package baseball.view;

import baseball.domain.PlayerNumbers;
import baseball.resource.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public PlayerNumbers inputNumber() {
        OutPutView.printInputMessage();
        String inputNumber = Console.readLine();

        return new PlayerNumbers(inputNumber);
    }
}
