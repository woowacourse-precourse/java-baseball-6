package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {
    // 사용자 한테 값을 입력받음.
    private int[] userArr = new int[3];


    public int[] input() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        exception(input); // 입력값 예외 처리

        for (int i = 0; i < 3; i++) {
            userArr[i] = Integer.parseInt(input.substring(i, i + 1)); // 입력 받은 문자열을 하나씩 잘라서 정수로 변환해서 정수 배열에 저장.
        }
        return userArr;
    }

    public int[] getUserArr() {
        return userArr;

    }

    /**
     * 예외 처리
     */
    private void exception(String input) {

        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자만 입력할 수 있습니다.");
        }

        final String REGEX = "[0-9]+";
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException("0~9 이외의 숫자는 입력할 수 없습니다.");
        }

    }

}
