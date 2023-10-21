package baseball;

public final class Validation {
    public static void validateOneOrTwo(String input){
        if(!(input.equals("1") || input.equals("2"))){
            throw new IllegalArgumentException("1 혹은 2를 입력하세요.");
        }
    }
    public static void validateUserInputSize(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }
    }
    public static void validateIsNumber(char input){
        if(input <= '0' || input > '9'){
            throw new IllegalArgumentException("1에서 9사이 숫자를 입력해주세요.");
        }
    }
    public static void validateDuplicatedNumber(boolean[] numberCheckArray, char number){
        if(numberCheckArray[number - '0']){
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요");
        }
        numberCheckArray[number - '0'] = true;
    }
}
