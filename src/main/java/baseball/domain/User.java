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
        try {
            checkSize(inputNumber, size);
            return getCheckInt(inputNumber, size);
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
            System.exit(1); // 예외 발생 시 프로그램 종료
            return null; // 이 부분은 실행되지 않겠지만, 컴파일러의 경고를 방지하기 위해 추가
        }
    }


    private void checkSize(String inputNumber, int size) {
        if (inputNumber.length() != size)
            throw new IllegalArgumentException("입력한 숫자의 길이가 올바르지 않습니다.");
    }
    private int[] getCheckInt(String inputNumber, int size) {
        int[] checkInt = new int[size];

        try {
            for (int i = 0; i < inputNumber.length(); i++) {
                if (!checkNum(inputNumber, i)) {
                    System.exit(1); // 예외 발생 시 프로그램 종료
                }

                checkInt[i] = convertCharToInt(inputNumber, i);
            }
        } catch (IllegalArgumentException e) {
            System.exit(1); // 예외 발생 시 프로그램 종료
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
