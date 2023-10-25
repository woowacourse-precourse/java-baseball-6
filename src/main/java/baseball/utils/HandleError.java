package baseball.utils;

public class HandleError {
    public static void validateInputStringIsNumber(String inputString) {
        char[] characters = inputString.toCharArray();

        for (char ch : characters) {
            //입력한 문자가 숫자로 이루어져 있는지
            if(!Character.isDigit(ch)) {
                throw new IllegalArgumentException("input value is not number");
            }
        }
    }
    public static void validateInputStringSize(String inputString, Integer size) {
        //입력한 문자가 size 인지
        if(inputString.length() != size) {
            throw new IllegalArgumentException("input number is not" + size + " characters long.");
        }
    }
}
