package baseball.v4;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 사용자의 숫자를 설정하고 유효성을 검사하는 클래스
public class ChallengerV4 implements SetNumV4 {

    // 사용자로부터 3개의 숫자를 설정하고 반환하는 메서드
    public List<Integer> setNum() {
        List<Integer> challengerNums = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        System.out.println(input);

        try {
            // 빈 입력 처리
            if (input.isEmpty()) {
                throw new IllegalArgumentException();
            }

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
                challengerNums.add(0, digit);
                parsedInput /= 10;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return challengerNums;
    }
}
