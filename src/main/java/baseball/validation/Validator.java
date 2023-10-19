package baseball.validation;

public class Validator {

    public void validateThreeNumber(String str){
        if(str.matches("[1-9]{3}")){
            throw new IllegalArgumentException("3자리의 숫자로 이루어진 문자가 아닙니다.");
        }
    }

}
