package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 1. 임의의 세자리 숫자(정답) 생성
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        System.out.println("answer: " + answer);

        // 2. 숫자 입력 받고 검증하기

        System.out.println("입력하세요: ");
        String input = Console.readLine();

        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }

        List<Integer> inputList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            inputList.add(input.charAt(i) - '0');
        }

        if (inputList.stream().distinct().collect(Collectors.toList()).size() != inputList.size()) {
            throw new IllegalArgumentException();
        }

        // 3. 스트라이크 계산
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (answer.get(i) == inputList.get(i)) {
                strike++;
                answer.set(i, 0);
            }
        }
        System.out.println("스트라이크: " + strike);

        // 4. 볼 계산
        int ball = 0;
        for (int num : inputList) {
            if (answer.contains(num)) {
                ball++;
            }
        }
        System.out.println("볼: " + ball);
    }
}
