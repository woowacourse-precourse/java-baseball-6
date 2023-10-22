package baseball;

public class ErrorHandler {

    public void checkErrorUserNumber(String userNumber){
        if(userNumber.length() <= 0 || userNumber.length() > 3){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        if(!userNumber.matches("^\\d+$")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    public void checkErrorAgainNumber(String againNumber){
        if(!againNumber.equals("1") && !againNumber.equals("2")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        if(!againNumber.matches("^\\d+$")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }
}
