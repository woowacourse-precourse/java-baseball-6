package baseball.domain;


public class User {

    int[] userNumbers;

    public int[] getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(int[] userNumbers) {
        this.userNumbers = userNumbers;
    }



    public int[] checkUserInput(String inputNumber) throws IllegalAccessException {
        checkSize(inputNumber);
        return getCheckInt(inputNumber);
    }


    private void checkSize(String inputNumber) throws IllegalAccessException {
        if (inputNumber.length() != 3)
            throw new IllegalAccessException();
    }
    private int[] getCheckInt(String inputNumber) throws IllegalAccessException {
        int[] checkInt = new int[3];

        for (int i = 0; i < inputNumber.length(); i++) {
            if (!checkNum(inputNumber, i))
                throw new IllegalAccessException();

            checkInt[i] = convertCharToInt(inputNumber, i);
        }
        return checkInt;
    }

    private int convertCharToInt(String inputNumber, int i) { //문자형을 정수형으로
        return inputNumber.charAt(i) - '0';   //이렇게 해주면 입력한 숫자 그대로 출력 됌.
    }

    private boolean checkNum(String inputNumber, int i) {
        return '0' <= inputNumber.charAt(i) && inputNumber.charAt(i) <= '9';    //숫자인지 확인
    }
}
