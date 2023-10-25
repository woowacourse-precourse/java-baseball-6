package player;

import camp.nextstep.edu.missionutils.Console;
import constants.MessageConstants;

import static constants.MessageConstants.*;
import static constants.NumConstants.*;


public class Player {

    public Player(){}

    public String getInputString(){
        System.out.print(MessageConstants.INPUT_MESSAGE);
        String inputString = Console.readLine();

        chkInputString(inputString);
        return inputString;
    }

    /**
     * 올바른 입력 문자열인지 판단
     * @param
     * @return
     */
    private void chkInputString(String inputString){
        if (inputString.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_LENGTH_ERROR_MESSAGE);
        }

        String tmp = "";
        for (char c : inputString.toCharArray()) {
            if (c <= '0' || c > '9') {
                throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_ONLY_INTEGER_ERROR_MESSAGE);
            }
            if (tmp.contains(String.valueOf(c))) {
                throw new IllegalArgumentException(ERROR_MESSAGE + INPUT_SAME_NUMBER_ERROR_MESSAGE);
            }
            tmp += String.valueOf(c);
        }
    }

    /**
     * 올바른 옵션값인지 판단 - 재시작(1), 종료(2)
     * @param
     * @return
     */
}
