package baseball.service;


public class InputValidator {
    /**
     * 입력값이 지정된 자리수인지 확인
     *
     * @param length           : 입력한 값 자리수
     * @param number_of_digits : 게임 입력값 지정 자리수
     * @return (true : 지정된 자리수와 같음, false : 지정된 자리수랑 다름)
     */
    public boolean lengthCheck(int length, int number_of_digits) {
        return length == number_of_digits;
    }

    /**
     * 입력값의 각 자리수가 서로다른 수인지 확인
     *
     * @param input_number : 입력값
     * @return (true : 각 자리수가 서로다른 수, false : 각 자리수가 서로다른 수가 아님)
     */
    public boolean validNumCheck(String input_number) {
        StringBuilder tmp = new StringBuilder();
        for (char c : input_number.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
            if ((tmp.toString()).contains(String.valueOf(c))) {
                return false;
            }
            tmp.append(c);
        }
        return true;
    }
}
