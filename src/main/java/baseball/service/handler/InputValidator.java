package baseball.service.handler;


public class InputValidator {
    /**
     * 입력값 표현형식 체크
     * <p>
     * 입력값이 지정된 자리수인지 확인, 입력값의 각 자리수가 1~9로 이루어졌는지 확인
     * </P>
     *
     * @param number           : 입력한 값
     * @param number_of_digits : 게임 입력값 지정 자리수
     * @return (true : 지정된 자리수와 같음, false : 지정된 자리수랑 다름)
     */
    public boolean regexCheck(String number, int number_of_digits) {

        return number.matches("[1-9]{" + number_of_digits + "}");
    }

    /**
     * 각 자리수가 서로다른 수인지 확인
     *
     * @param input_number : 입력값
     * @return (true : 각 자리수가 서로다른 수, false : 각 자리수가 서로다른 수가 아님)
     */
    public boolean IsDifferentEachDigit(String input_number) {
        StringBuilder tmp = new StringBuilder();
        for (char c : input_number.toCharArray()) {
            if ((tmp.toString()).contains(String.valueOf(c))) {
                return false;
            }
            tmp.append(c);
        }
        return true;
    }

}
