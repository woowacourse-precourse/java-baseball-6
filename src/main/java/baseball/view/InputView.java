package baseball.view;

import baseball.util.Messages;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String getUserNumber() {
        System.out.print(Messages.GET_USER_NUMBER_MESSAGE.getMessage());
        return readLine();
    }
}
