package player;

import constants.MessageConstants;
import view.Input;

import static constants.MessageConstants.*;
import static constants.NumConstants.*;
import static view.Input.readOption;


public class Player {

    public Player(){}

    public String start(){
        String inputString = Input.readInput();
        chkInputString(inputString);
        return inputString;
    }

    private void chkInputString(String inputString){
        if (inputString.length() != INPUT_LENGTH) {
            throw new IllegalStateException(ERROR_MESSAGE + INPUT_LENGTH_ERROR_MESSAGE);
        }

        String tmp = "";
        for (char c : inputString.toCharArray()) {
            if (c <= '0' || c > '9') {
                throw new IllegalStateException(ERROR_MESSAGE + INPUT_ONLY_INTEGER_ERROR_MESSAGE);
            }
            if (tmp.contains(String.valueOf(c))) {
                throw new IllegalStateException(ERROR_MESSAGE + INPUT_SAME_NUMBER_ERROR_MESSAGE);
            }
            tmp += String.valueOf(c);
        }
    }

}
