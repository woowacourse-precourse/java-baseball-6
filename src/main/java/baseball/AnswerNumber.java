package baseball;

import java.util.HashSet;
import java.util.Set;

public class AnswerNumber {

    private String answerNumber;

    public AnswerNumber(String answerNumber){
        if(isNumberFormatMatch(answerNumber)) {
            this.answerNumber = answerNumber;
        }
    }

    public String getAnswerNumber(){
        return answerNumber;
    }

    public boolean isNumberLengthThree(String number){
        if(number.length()!=3) return false;
        return true;
    }

    public boolean isNumberRangeOnetoNine(String number){
        String regex = "^[1-9]{3}";
        if(!number.matches(regex)) return false;

        return true;
    }

    public boolean isAllDifferentNumber(String number){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<number.length();i++){
            char num = number.charAt(i);
            if(set.contains(num)) return false;
            set.add(num);
        }
        return true;
    }

    public boolean isNumberFormatMatch(String number) throws IllegalArgumentException{
        if(isNumberLengthThree(number)&&isNumberRangeOnetoNine(number)&&isAllDifferentNumber(number)){
            return true;
        }
        throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
    }

}
