package baseball;

public class Note {
    private final String answerNumber;

    private Note(String number) throws IllegalArgumentException {
        classInvariant(number);
        this.answerNumber = number;
    }

    private void classInvariant(String number) {
        checkThreeDigits(number);
        checkDigitsUnique(number);
    }

    private void checkThreeDigits(String number) throws IllegalArgumentException{
        final int threeDigits = 3;
        final char numberLowerBound = '1';
        final char numberUpperBound = '9';
        if (number.length() != threeDigits) {
            throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c < numberLowerBound || c > numberUpperBound) {
                throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다");
            }
        }
    }

    public static Note writeDown(String number) throws IllegalArgumentException{
        return new Note(number);
    }

    @Override
    public String toString() {
        return this.answerNumber;
    }


    private void checkDigitsUnique(String number) throws IllegalArgumentException{
        char firstNumber = number.charAt(0);
        char secondNumber = number.charAt(1);
        char thirdNumber = number.charAt(2);
        if(firstNumber == secondNumber || secondNumber == thirdNumber || firstNumber == thirdNumber){
            throw new IllegalArgumentException("중복되지 않은 값을 입력하세요");
        }
    }
}
