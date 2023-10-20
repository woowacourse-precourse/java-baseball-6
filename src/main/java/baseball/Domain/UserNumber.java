package baseball.Domain;

import java.util.Arrays;

public class UserNumber {
    private String number;

    private static int NUMBER_RANGE_START = 1;
    private static int NUMBER_RANGE_END = 9;

    public UserNumber(String number){
        validate(number);
        this.number = removeSpace(number);
    }

    private String removeSpace(String number){ // 공백 제거
        return number.replaceAll(" ",null);
    }

    public String getNumber(){
        return number;
    }

    private void validate(String number){

        if(isEmpty(number)){ // 수가 비어있는 경우
            throw new IllegalArgumentException();
        }

        if(!isSizeThree(number)){ // 3자리 수가 아닌 경우
            throw new IllegalArgumentException();
        }

        if(!isDigit(number)){ // 각 자리가 숫자가 아닌경우
            throw new IllegalArgumentException();
        }

        if(!isBetweenOneAndNine(number)){ // 각 자리의 수가 1~9 값이 아닌 경우
            throw new IllegalArgumentException();
        }
    }

    private boolean isBetweenOneAndNine(String number){ // 1과 9사이에 존재하는지
        String[] arr = number.split("");

        return Arrays.stream(arr).allMatch(
                value -> Integer.valueOf(value) >= NUMBER_RANGE_START && Integer.valueOf(value) <= NUMBER_RANGE_END
        );
    }

    private boolean isDigit(String number){
        String[] arr = number.split("");
        return Arrays.stream(arr).allMatch(value -> Character.isDigit(value.charAt(0)));
    }
    private boolean isEmpty(String number){
        return number.isBlank() || number == null;
    }

    private boolean isSizeThree(String number){
        return number.length() == 3;
    }
}
