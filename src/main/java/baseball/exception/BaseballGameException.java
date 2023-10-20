package baseball.exception;

import java.util.HashSet;

public class BaseballGameException {
    public void validPlayerNumIsInt(String playerNumStr) {
        try{
            Integer.parseInt(playerNumStr);
        } catch (IllegalArgumentException e){
            System.out.println("\n[Error] 세 자리 자연수를 입력하세요.");
            throw e;
        }
    }

    public void validPlayerNumLenCount(String playerNumStr) {
        if(playerNumStr.length() !=3){
            System.out.println("\n[Error] 세 자리 수를 입력하세요.");
            throw new IllegalArgumentException("");
        }
    }

    public void validPlayerNumIsDuplicate(String playerNumStr) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<3;i++) {
            set.add(playerNumStr.charAt(i));
        }
        if(set.size()!=3){
            System.out.println("\n[Error] 서로 다른 숫자로 이루어진 숫자를 입력하세요.");
            throw new IllegalArgumentException("");
        }
    }

    public void validRegameNumStrLen(String regameNumStr){
        if(regameNumStr.length()!=1){
            System.out.println("[Error] 1 또는 2를 입력하세요.");
            throw new IllegalArgumentException("");
        }
    }

    public void validRegameNumStrIsCorrect(String regameNumStr) {
        if(!(regameNumStr.equals("1")||regameNumStr.equals("2"))){
            System.out.println("[Error] 1 또는 2를 입력하세요.");
            throw new IllegalArgumentException("");
        }
    }
}
