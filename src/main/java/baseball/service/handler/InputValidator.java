package baseball.service.handler;


public class InputValidator {
    /**
     * 입력값 표현형식 체크
     * <p>
     * 입력값이 지정된 자리수인지 확인,
     * <br> 입력값의 각 자리수가 1~9로 이루어졌는지 확인
     * </P>
     *
     * @param number         : 입력한 값
     * @param numberOfDigits : 게임 입력값 지정 자리수
     * @return (true : 지정된 자리수와 같음, false : 지정된 자리수랑 다름)
     */
    public boolean regexCheck(String number, int numberOfDigits) {

        return number.matches("[1-9]{" + numberOfDigits + "}");
    }

    /**
     * 각 자리수가 서로다른 수인지 확인
     *
     * @param inputNumber : 입력값
     * @return (true : 각 자리수가 서로다른 수, false : 각 자리수가 서로다른 수가 아님)
     */
    public boolean isDifferentEachDigit(String inputNumber) {
        StringBuilder tmpForCompare = new StringBuilder();
        for (char c : inputNumber.toCharArray()) {
            if ((tmpForCompare.toString()).contains(String.valueOf(c))) {
                return false;
            }
            tmpForCompare.append(c);
        }
        return true;
    }

}
