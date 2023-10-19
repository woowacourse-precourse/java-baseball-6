package baseball.model;

public class UserNumber {

    /**
     * 숫자가 아닐 경우 예외 발생
     */
    public static void isDigitNumber(String inputWord){
        for (int i = 0; i < inputWord.length(); i++){
            checkIsDigit(inputWord, i);
        }
    }

    public static void checkIsDigit(String inputWord, int idx) throws IllegalArgumentException{
        if (!Character.isDigit(inputWord.charAt(idx))) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
