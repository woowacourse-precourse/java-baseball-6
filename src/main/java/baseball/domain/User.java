package baseball.domain;


public class User {

    int MyinputList[];

    public int[] getMyinputList() {
        return MyinputList;
    }

    public void setMyinputList(int[] myinputList) {
        MyinputList = myinputList;
    }

    public int[] checkUserInput(String inputNumber, int size) throws IllegalAccessException {
        checkSize(inputNumber, size);
        return getCheckInt(inputNumber, size);
    }


    private static void checkSize(String inputNumber, int size) throws IllegalAccessException {
        if (inputNumber.length() != size)
            throw new IllegalAccessException();
    }
    private static int[] getCheckInt(String inputNumber, int size) throws IllegalAccessException {
        int[] checkInt = new int[size];

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
