package baseball.view;

import baseball.util.InputMessage;
import baseball.util.Utils;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public void printStart() {
        System.out.println(InputMessage.START.getMessage());
    }

    public List<Integer> printInsertNumber() {
        System.out.println(InputMessage.INSERT_NUMBER.getMessage());
        return Utils.stringToList(Console.readLine());
    }

    public void printCorrect() {
        System.out.println(InputMessage.CORRECT.getMessage());
    }

    public int printEnd() {
        System.out.println(InputMessage.END.getMessage());
        return Utils.stringToInt(Console.readLine());
    }

}
