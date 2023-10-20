package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerV2 implements SetNumV2 {
    public List<Integer> setNum() {
        List<Integer> playerNums = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        try {
            // 1~9 사이의 숫자 검증
            if (!input.matches("[1-9]+")) {
                throw new IllegalArgumentException();
            }

            // 입력받은 숫자가 3자리가 맞는지 확인
            if (input.length() != 3) {
                throw new IllegalArgumentException();
            }

            Integer parsedInput = Integer.parseInt(input);

            // 입력 받은 수에 중복된 숫자가 있는지 확인
            Set<Integer> uniqueDigits = new HashSet<>();
            while (parsedInput > 0) {
                int digit = parsedInput % 10;
                if (!uniqueDigits.add(digit)) {
                    throw new IllegalArgumentException();
                }
                playerNums.add(0, digit);
                parsedInput /= 10;
            }
        } catch (IllegalArgumentException e) {
            HostV2.stop();
        }
        return playerNums;
    }


}
