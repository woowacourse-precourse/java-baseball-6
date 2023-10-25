package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class INPUT {
    static List<Integer> UserInput() {
        // 사용자 입력
        System.out.println("숫자를 입력해주세요: ");
        List<Integer> user = new ArrayList<Integer>();
        String input = Console.readLine();

        try {
            // 숫자 3개 입력!
            if (Integer.parseInt(input) < 100 || Integer.parseInt(input) > 999) {
                throw new IllegalArgumentException();
            }

            // 1~9 숫자만 입력 받아야 되니까 0 입력받으면 예외
            for (int i = 0; i < 3; i++) {
                if (input.charAt(i) - '0' == 0)
                    throw new IllegalArgumentException();
            }

            // 서로 다른 3개의 숫자 -> 하나라도 같으면 예외 발생
            if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(2))
                throw new IllegalArgumentException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }


        user.add(Integer.parseInt(String.valueOf(input.charAt(0))));
        user.add(Integer.parseInt(String.valueOf(input.charAt(1))));
        user.add(Integer.parseInt(String.valueOf(input.charAt(2))));
        return user;
    }
}