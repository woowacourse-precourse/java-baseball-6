package baseball;

public class CheckingInput {

    /*
    2️⃣ 잘못된 값을 검사하는 기능
    - 사용자의 입력값이 잘못된 경우, Exception을 발생시킨다.
     */

    public void CheckAll(String input) throws IllegalArgumentException {
        if ((CheckRange(input) && CheckDifference(input)) == false) {
            throw new IllegalArgumentException();
        }
    }
    public boolean CheckRange (String input) {
        Integer int_input = Integer.parseInt(input);
        if (int_input > 111 && int_input < 999) {
            return true;
        } else {
            return false;
        }
    }
    public boolean CheckDifference (String input) {
        char firstNum = input.charAt(0);
        char secondNum = input.charAt(1);
        char thirdNum= input.charAt(2);
        if (firstNum != secondNum && secondNum != thirdNum && thirdNum != firstNum) {
            return true;
        } else {
            return false;
        }
    }

}
