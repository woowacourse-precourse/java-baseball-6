package baseball;
import camp.nextstep.edu.missionutils.Console;

public class UserNumber {
    private String userNumber;

    public UserNumber() {

    }

    public void setUserNumber(String userNumber){
        validateLength(userNumber);
        validateNumber(userNumber);
        validateDuplication(userNumber);
        this.userNumber = userNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void validateLength(String userNumber){
        if(userNumber.length() != 3){
            throw new IllegalArgumentException("숫자는 3자리 입니다.");
        }
    }

    public void validateNumber(String userNumber){
        if(!userNumber.matches("^[1-9]*$")){
            throw new IllegalArgumentException("1 ~ 9 까지의 숫자를 입력 해주세요.");
        }
    }

    public void validateDuplication(String userNumber){
        for(int i = 0; i < userNumber.length(); i++){
            for(int j = i+1; j < userNumber.length(); j++){
                if(userNumber.charAt(i) == userNumber.charAt(j)){
                    throw new IllegalArgumentException("숫자가 중복될 순 없습니다.");
                }
            }
        }
    }


}