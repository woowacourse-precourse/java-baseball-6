package baseball;

public class ErrorHandler {

    // 유저 숫자 에러 검사
    public void checkErrorUserNumber(String userNumber){
        if(userNumber.length() != 3){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        if(!userNumber.matches("^\\d+$")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }

    // 게임 다시 시작 숫자 에러 검사
    public void checkErrorAgainNumber(String againNumber){
        if(!againNumber.equals("1") && !againNumber.equals("2")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
        if(!againNumber.matches("^\\d+$")){
            throw new IllegalArgumentException("잘못된 숫자 입력입니다.");
        }
    }
}
