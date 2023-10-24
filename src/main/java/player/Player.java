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
            throw new IllegalStateException(INPUT_LENGTH_ERROR_MESSAGE);
        }
        // 예외처리 추가
    }

}
