package baseball.models;

import baseball.views.InputView;

public class RegameNumber {
    private String regameNumber;

    public String getRegameNumber(){

        return regameNumber;
    }

    public RegameNumber(String regameNumber) {
        isCorrectRegameNumber(regameNumber);
        this.regameNumber = regameNumber;
    }

    public static void isCorrectRegameNumber(String number) throws IllegalArgumentException {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }
}
