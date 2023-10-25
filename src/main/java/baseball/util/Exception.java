package baseball.util;

public class Exception {

    //1. 3자리가 아닐 때
    public static void notThreeNum(String input){

        if(input.length() != 3){
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

    }

    //2. 숫자가 아닐 때
    public static void notNum(String input){

        for (int i = 0; i < 3; i++) {
            isNum(input.charAt(i));
        }

    }

    //값이 숫자인지 검증
    public static void isNum(char input){

        if(input < '1' || input > '9'){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

    }

    //3. 중복된 숫자가 있을 때
    public static void duplicateNum(String input){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < i; j++) {
                isSameNum(input.charAt(i), input.charAt(j));
            }
        }

    }

    //같은 값 인지 검증
    public static void isSameNum(char input1, char input2){

        if(input1 == input2){
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }

    }
}
