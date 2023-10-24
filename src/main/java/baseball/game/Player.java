package baseball.game;

import camp.nextstep.edu.missionutils.Console;

public class Player {

    public String inputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        String answer = Console.readLine();

        if (!isValidNum(answer)) {
            throw new IllegalArgumentException("입력 받은 숫자가 유효하지 않습니다.");
        }
        return answer;
    }

    private boolean isValidNum(String str) {
        return hasValidLength(str) && hasNoDuplicateChars(str);
    }

    private boolean hasValidLength(String str) {
        return str.length() == 3;
    }

    private boolean hasNoDuplicateChars(String str) {
        char first = str.charAt(0);
        char second = str.charAt(1);
        char third = str.charAt(2);

        return first != second && second != third && first != third;
    }
}
