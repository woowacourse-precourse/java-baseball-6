package baseball;

public class Note {
    private final String number;

    private Note(String number) throws IllegalArgumentException {
        classInvariant(number);
        this.number = number;
    }

    private void classInvariant(String number) {
        checkThreeDigits(number);
        checkDigitsUnique(number);
    }

    private void checkThreeDigits(String number) throws IllegalArgumentException{
        if (number.length() != 3) {
            throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다.");
        }

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c < '1' || c > '9') {
                throw new IllegalArgumentException("3자리의 정수를 입력해야 합니다");
            }
        }
    }

    public static Note writeDown(String number) throws IllegalArgumentException{
        return new Note(number);
    }

    @Override
    public String toString() {
        return this.number;
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
