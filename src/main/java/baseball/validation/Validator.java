package baseball.validation;

public class Validator {

    public boolean isThreeNumber(String str){
        if(str.matches("[1-9]{3}")){
            return true;
        }
        return false;
    }
}
