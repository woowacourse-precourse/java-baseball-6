package baseball.exception;

import java.util.HashSet;

public class BaseballGameException {
    public void validPlayerNumIsInt(String playerNumStr) {
        try{
            Integer.parseInt(playerNumStr);
        } catch (IllegalArgumentException e){
            throw e;
        }
    }

    public void validPlayerNumLenCount(String playerNumStr) {
        if(playerNumStr.length()!=3){
            throw new IllegalArgumentException();
        }
    }
}
