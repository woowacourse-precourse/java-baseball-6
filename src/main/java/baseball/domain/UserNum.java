package baseball.domain;

import java.util.HashSet;
import java.util.Set;

public class UserNum {
    private String userNum;

    public UserNum(String userNum){
        isStrLenCorrect(userNum);
        isDuplicateCheck(userNum);
        isDigitUserNum(userNum);
        this.userNum = userNum;
    }

    public String getUserNum(){
        return userNum;
    }

    public static void isStrLenCorrect(String sl) throws IllegalArgumentException{
        if(sl.length() != 3){
            throw new IllegalArgumentException("잘못된 값 입력. 3자리를 입력해주세요.");
        }
    }

    public static void isDigitCheck(String s, int index) throws IllegalArgumentException{
        if(!Character.isDigit(s.charAt(index))){
            throw new IllegalArgumentException("잘못된 값 입력. 숫자를 입력해주세요.");
        }
    }

    public static void isDigitUserNum(String sU){
        for(int i = 0; i < sU.length(); i++){
            isDigitCheck(sU, i);
        }
    }

    public static void isDuplicateCheck(String s) throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        if (set.size() != s.length()) {
            throw new IllegalArgumentException("잘못된 값 입력. 중복된 수가 있습니다.");
        }
    }
}