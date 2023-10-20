package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    public static List<Integer> user() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        // 입력 문자열 길이 검증(
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        List<Integer> answerCandidate = new ArrayList<>();
        for (char c : input.toCharArray()) {
            // 0 혹은 양수인 수(소수X) 변환 가능할 경우
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);

                // 서로 다른 숫자를 입력했는지도 체크
                if (answerCandidate.contains(digit)){
                    throw new IllegalArgumentException();
                }
                else {
                    answerCandidate.add(Character.getNumericValue(c));
                }
            }
            // 문자, 소수, 음수, 공백이 포함되어 있을 경우
            else {
                throw new IllegalArgumentException();
            }
        }

        return answerCandidate;
    }
}
