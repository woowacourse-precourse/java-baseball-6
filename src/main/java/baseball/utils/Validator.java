package baseball.utils;

public class Validator {

    public int[] validateUserInput(String input, int size) throws  IllegalArgumentException{
        checkSize(input, size);
        return getValidateInt(input, size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException{
        if (input.length() != size){
            throw new IllegalArgumentException("숫자의 크기는 3개를 넘어가면 안됩니다.");
        }
    }

    private int[] getValidateInt(String input, int size) throws IllegalArgumentException{
        int[] validateInt = new int[size];

        for (int i = 0; i < input.length(); i++){
            if (!checkDigit(input, i)){
                throw new IllegalArgumentException("숫자를 입력해주세요");
            }
            validateInt[i] = convertCharToInt(input, i);
        }
        return validateInt;
    }

    private int convertCharToInt(String input, int i) {return input.charAt(i) - '0';}

    private Boolean checkDigit(String input, int i) {return '0' <= input.charAt(i) && input.charAt(i) <= '9';}







    /**사용자의 입력값이 3을 넘어가는 지 확인하는 메소드**/

    /**사용자가 숫자를 입력했는지 확인하는 메소드**/
}
