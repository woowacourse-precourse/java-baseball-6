package baseball;

import java.util.stream.IntStream;

public class InputValidate {

    private final String input;
    private static final int ORIGINCOUNT =3;

    public InputValidate(String input) {
        this.input=input;
    }

    protected void validateInput(){
        validateNumber();
        validateSize();
        validateContainsZero();
        validateDuplicateNumber();
    }

    private void validateSize() {
        if(input.length()!= ORIGINCOUNT) {
            System.out.println("글자수 이상해요");
            throw new IllegalArgumentException("입력글자 수는 3글자 미만 또는 3글자 초과할 수 없습니다.");
        }
    }

    private void validateNumber(){
        if(!input.chars().allMatch(Character::isDigit)){
            System.out.println("숫자 외의 문자 포함 ");
            throw new IllegalArgumentException("1부터 9까지의 수 중 서로 다른 3가지 수를 입력하셔야 합니다.");
        }
    }

    private void validateContainsZero(){
        if(input.contains("0")){
            System.out.println("0을 포함했다 ");
            throw new IllegalArgumentException("0을 입력할 수 없습니다. 1~9까지의 수 중 서로 다른 3가지 수를 입력해주세요");
        }
    }

    private void validateDuplicateNumber(){
        if(input.charAt(0) == input.charAt(1) || input.charAt(1)==input.charAt(2) || input.charAt(2)==input.charAt(0)){
            System.out.println("동일한 숫자가 포함되어 있어요");
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다. 1~9까지의 수 중 서로 다른 3가지 수를 입력해주세요");
        }
    }

}
