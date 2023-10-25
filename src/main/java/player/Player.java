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

    public boolean getOptionString(){
        System.out.println(MessageConstants.RESTART_OR_FINISH_MESSAGE);
        String optionString = Console.readLine();

        return chkOptionString(optionString);
    }

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

    private boolean chkOptionString(String optionString){
        if (optionString.equals(String.valueOf(OPTION_RESTART))) {
            return true;
        } else if (optionString.equals(String.valueOf(OPTION_FINISH))) {
            return false;
        } else {
            throw new IllegalArgumentException(OPTION_INPUT_ERROR_MESSAGE);
        }
    }

}
