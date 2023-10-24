package baseball.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class User {
    private String input;

    //올바른 입력 값인지 검증
    public boolean isValidInput(String input) {
        //3자리가 아닌 경우
        if (input.length() != 3) {
            return false;
        }

        boolean isDuplicated[] = new boolean[10];
        Arrays.fill(isDuplicated, false);

        for (int i = 0; i < input.length(); i++) {
            int x = input.charAt(i) - '0';

            //1과 9 사이의 숫자가 아닌 경우
            if (x < 1 || x > 9) {
                return false;
            }

            //서로 다른 숫자가 아닌 경우
            if (isDuplicated[input.charAt(i) - '0']) {
                return false;
            }

            //이미 등장한 숫자임을 표시
            isDuplicated[input.charAt(i) - '0'] = true;
        }

        return true;
    }

    //사용자 입력 받기
    public void setInput() {
        String attempt;
        System.out.print("숫자를 입력해주세요 : ");
        attempt = Console.readLine();

        if (!isValidInput(attempt)) {
            throw new IllegalArgumentException();
        }

        this.input = attempt;
    }

    public String getInput() {
        return input;
    }
}
