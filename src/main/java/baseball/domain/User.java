package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    // 숫자를 입력하고 결과를 넘겨주는 도메인 객체
    // 유저가 입력한 3자리 번호를 return, 게임종료후, 재시작 여부 숫자 return. (넘겨주고-2개)
    // 본인 번호 입력, 재시작 여부 숫자 입력 (입력받고-2개)
    // user가 하는 모든 입력에 대해서 유효하지 않으면 exception 처리 시켜야함.
    // 1 - 야구숫자 입력에 대한 에러, 1또는2 가 아닌 숫자 입력에 대한 에러 핸들링
    private String baseballNumber;
    private String retryNumber;

    public String returnBaseballNumber() {
        return baseballNumber;
    }

    public String returnRetryNumber() {
        return retryNumber;
    }

    public void inputNumber() {
        this.baseballNumber = Console.readLine();
    }

    public void selectRetry() {
        this.retryNumber = Console.readLine();
    }

    // 야구 숫자 입력에 대한 에러 핸들링 1 or 2 -> 2진수 + 1 처리
    public boolean isValidRetry() {
        // 1자리가 아니면,
        if (returnRetryNumber().length() != 1)
            return false;

        // 숫자가 아니면
        if (!Character.isDigit(retryNumber.charAt(0)))
            return false;

        // retryNumber가 1인지 2인지 확인
        int retryValue = Integer.parseInt(returnRetryNumber());
        return retryValue == 1 || retryValue == 2;

    }

    public boolean isValidInput() {
        // 3자리가 아니면,
        if (returnBaseballNumber().length() != 3)
            return false;

        // 입력값이 1~9 사이의 숫자로 이루어져 있는가 확인
        if (!returnBaseballNumber().matches("[1-9]{3}"))
            return false;

        // 중복된 숫자가 있는지 확인
        char[] digits = returnBaseballNumber().toCharArray();
        for (int i = 0; i < digits.length; i++) {
            for (int j = i+1; j < digits.length; j++) {
                if (digits[i] == digits[j]) {
                    return false;
                }
            }
        }
        // 모든 조건을 통과하면 유효한 입력이다.
        return true;
    }


}
