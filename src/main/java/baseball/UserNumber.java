package baseball;
import java.util.HashSet;
import java.util.Set;

public class UserNumber {

    private static final int MAX_NUMBER_LENGTH = 3;
    private final String userNumber;


    public UserNumber(String number) {
        validateLength(number);
        validateNumber(number);
        validateDuplication(number);
        this.userNumber = number;
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

    public void validateDuplication(String number){
        Set<Character> validateNumber = getCharacters(number);
        if(validateNumber.size() != 3){
            throw new IllegalArgumentException("숫자가 중복될 수 없습니다.");
        }
    }

    private Set<Character> getCharacters(String number) {
        Set<Character> validateNumber = new HashSet<>();

        for(int i = 0; i < MAX_NUMBER_LENGTH; i++){
            validateNumber.add(number.charAt(i));
        }
        return validateNumber;
    }



}