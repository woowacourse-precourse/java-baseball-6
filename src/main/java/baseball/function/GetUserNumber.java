package baseball.function;

import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;

public class GetUserNumber {
    public static int[] getUserNumber() throws IllegalArgumentException {

        Message.inputMessage();
        String input = Console.readLine();
        ChkDigit chkDigit = new ChkDigit();
        chkDigit.chkIsNum(input);
        chkDigit.chkSize(input);


        int[] inputNum  = new int[3];
        for (int i = 0; i < 3; i++) {
            inputNum[i] = input.charAt(i) - '0';
        }

        for (int i = 0; i < 3; i++) {
            if (!chkDigit.chkUnique(inputNum, i, inputNum[i])) {
                throw new IllegalArgumentException();
            }
        }
        return inputNum;
    }
}