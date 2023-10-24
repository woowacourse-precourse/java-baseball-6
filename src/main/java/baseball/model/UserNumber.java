package baseball.model;

public class UserNumber {
    private String userNumber;


    public UserNumber(String input){
        validate(input);
        this.userNumber = input;
    }

    public String getUserNumber(){
        return userNumber;
    }

    private void validate(String input){
        validateIsNumber(input);
        validateSize(input);
        validateHasZero(input);
        validateDuplicate(input);
    }

    private void validateIsNumber(String input){
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c))
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void validateSize(String input){
        if(input.length()!=3)
            throw new IllegalArgumentException("세 자리의 숫자만 입력 가능합니다.");
    }

    private void validateHasZero(String input){
        if(input.contains("0"))
            throw new IllegalArgumentException("1-9 사이의 숫자만 입력 가능합니다.");
    }

    private void validateDuplicate(String input){
        char[] inputToArray = input.toCharArray();
        if(inputToArray[0]==inputToArray[1] || inputToArray[0]==inputToArray[2] || inputToArray[1]==inputToArray[2])
            throw new IllegalArgumentException("세 자리 수는 모두 달라야합니다.");
    }

}