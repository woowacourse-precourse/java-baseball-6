package baseball.function;

import baseball.view.Message;
import camp.nextstep.edu.missionutils.Console;

import baseball.function.ChkDigit;

public class GetUserNumber {
    public int[] getuserNumber() throws IllegalArgumentException {

        Message.InputNessage();
        String input = Console.readLine();
        ChkDigit chkDigit = new ChkDigit();
        chkDigit.ChkIsNum(input);
        chkDigit.ChkSize(input);


        int inputnum[] = new int[3];
        for (int i = 0; i < 3; i++) {
            inputnum[i] = input.charAt(i) - '0';
        }

        for (int i = 0; i < 3; i++) {
            if (!chkDigit.ChkUnique(inputnum, i, inputnum[i])) {
                throw new IllegalArgumentException();
            }
        }
        return inputnum;
    }
}