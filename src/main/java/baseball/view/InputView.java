package baseball.view;

import baseball.domain.Numbers;
import baseball.domain.PlayerNumbersManager;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static Numbers inputNumber() {
        OutPutView.printInputMessage();
        String inputNumber = Console.readLine();
        PlayerNumbersManager.checkPlayerNumberAndCreate(inputNumber);
        return new Numbers(inputNumber);
    }
}
