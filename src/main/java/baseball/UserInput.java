package baseball;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public static String getUserInput() {

        System.out.print("숫자를 입력해주세요 : ");

        String inputString = Console.readLine(); // 사용자 입력 값

        String exceptionMassage = "입력 값은 서로다른 3자리 숫자로 입력해야합니다."; // 예외 처리 메시지

        // 3자리 숫자 유효성 검사
        int inputNum;
        try {
            inputNum = Integer.parseInt(inputString);
        } catch (Exception e) { // 입력한 값이 숫자가 아닌 문자인 경우 IllegalArgumentException 발생
            throw new IllegalArgumentException(exceptionMassage);
        }

        // 사용자가 입력한 숫자에 중복이 있으면 IllegalArgumentException 발생
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            int indexOf = inputString.indexOf(c);
            if (i != indexOf) { // 중복의 숫자가 있는 경우
                throw new IllegalArgumentException(exceptionMassage);
            }
        }

        // 입력한 숫자가 3자리가 아니면 IllegalArgumentException 발생
        int numLength = (int) (Math.log10(inputNum) + 1); // 입력받는 숫자의 자릿수
        if (numLength != 3) {
            throw new IllegalArgumentException(exceptionMassage);
        }

        return inputString;
    }
}
