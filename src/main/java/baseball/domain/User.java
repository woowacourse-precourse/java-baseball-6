package baseball.domain;


public class User {

    int[] userNumbers;

    public int[] getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(int[] userNumbers) {
        this.userNumbers = userNumbers;
    }

    public int[] checkUserInput(String inputNumber, int size) {
        checkSize(inputNumber, size);
        return getCheckInt(inputNumber, size);
    }

    private void checkSize(String inputNumber, int size) throws IllegalArgumentException{
        if (inputNumber.length() != size)
            throw new IllegalArgumentException();
    }
    private int[] getCheckInt(String inputNumber, int size) throws IllegalArgumentException{
        int checkInt[] = new int[size];

        for (int i = 0; i < inputNumber.length(); i++) {
            if (!checkDigit(inputNumber,i)) {
                throw new IllegalArgumentException();
            }
            checkInt[i] = convertChartoInt(inputNumber, i);
        }
        return checkInt;
    }

    private int convertChartoInt(String inputNumber, int i) {
        return inputNumber.charAt(i) - '0'; //입력한 숫자 그대로 나타남
    }

    private boolean checkDigit(String inputNumber, int i){
        return '0' <= inputNumber.charAt(i) && inputNumber.charAt(i) <= '9';
    }
}