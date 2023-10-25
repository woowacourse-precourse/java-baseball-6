package baseball;

public class ValidateInput {
    public static void validateDuplicate(String input){
        if(input.length() != input.chars().distinct().boxed().toList().size()) { // 중복 수 제거랑 기존 input과 비교로 중복확인
            throw new IllegalArgumentException(String.format("숫자가 중복되었습니다."));
        }
    }
    public static void validate(String input, String regex, String errorMessage) {
        if(!input.matches(regex)){
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
