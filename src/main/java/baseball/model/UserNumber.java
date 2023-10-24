package baseball.model;

import baseball.util.Constant;
import java.util.HashSet;
import java.util.Set;

public class UserNumber {

    private String userNumber;

    public UserNumber(String userNumber) {

        isDigitUserNumber(userNumber);
        isStringLengthCorrect(userNumber);
        isDifferentUserNumber(userNumber);

        this.userNumber = userNumber;
    }

    public String getUserNumber(){
        return userNumber;
    }

    public static boolean isDigitUserNumber(String word) {
        for(int i=0;i< word.length(); i++){
            isDigitCharInString(word,i);
        }
        return true;
    }
    public static boolean isStringLengthCorrect(String word) throws IllegalArgumentException {
        if(word.length() != Constant.MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        return true;
    }

    public static boolean isDifferentUserNumber(String word) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();

        for(int i = 0; i<word.length(); i++) {
            set.add(word.charAt(i));
        }
        if(set.size() != word.length()){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        return true;
    }

    public static boolean isDigitCharInString(String word,int index) throws IllegalArgumentException {
        if(!Character.isDigit(word.charAt(index))){
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
        return true;
    }
}
