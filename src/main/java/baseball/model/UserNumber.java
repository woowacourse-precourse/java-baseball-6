package baseball.model;

public class UserNumber {

    /**
     * 숫자가 아닐 경우 예외 발생
     */
    public static void checkIsDigit(String inputWord){
        for (int i = 0; i < inputWord.length(); i++){
            isDigitNumber(inputWord, i);
        }
    }

    public static void isDigitNumber(String inputWord, int idx){
        if (!Character.isDigit(inputWord.charAt(idx))) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    /**
     * 세자리 숫자가 아닐 경우 예외 발생
     */
    public static void checkIsThree(String inputWord){
        if (inputWord.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
    }
}
