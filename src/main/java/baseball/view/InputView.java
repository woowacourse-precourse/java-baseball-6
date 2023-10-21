package baseball.view;

import baseball.util.InputMessage;
import baseball.util.Utils;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public void printStart() {
        System.out.println(InputMessage.START);
    }

    public List<Integer> printInsertNumber() {
        System.out.println(InputMessage.INSERT_NUMBER);
        return Utils.stringToList(Console.readLine());
    }
}
