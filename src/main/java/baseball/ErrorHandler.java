package baseball;

public class ErrorHandler {

    public void checkErrorUserNumber(String number){
        if(number.length() <= 0 || number.length() > 3){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        if(!number.matches("^\\d+$")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    public void checkErrorAgainNumber(String number){
        if(!number.equals("1") && !number.equals("2")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        if(!number.matches("^\\d+$")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }
}
