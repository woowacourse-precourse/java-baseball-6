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

    public void validPlayerNumIsDuplicate(String playerNumStr) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<3;i++) {
            set.add(playerNumStr.charAt(i));
        }
        if(set.size()!=3){
            throw new IllegalArgumentException();
        }
    }

    public void validRegameNumStrLen(String regameNumStr){
        if(regameNumStr.length()!=1){
            throw new IllegalArgumentException();
        }
    }

    public void validRegameNumStrIsCorrect(String regameNumStr) {
        if(!(regameNumStr.equals("1")||regameNumStr.equals("2"))){
            throw new IllegalArgumentException();
        }
    }
}
