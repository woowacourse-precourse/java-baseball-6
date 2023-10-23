package baseball.view;

import static baseball.model.Message.INPUT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputGameIng() {
        System.out.print(INPUT.getMessage());
        return Console.readLine();
    }
}
