package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final int NUMBER_OF_DIGITS = 3;

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 정답 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) computer.add(randomNumber);
        }

        // 정답 입력
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$")) throw new IllegalArgumentException("서로 다른 3개의 숫자를 공백 없이 입력해 주세요.");

        // 정답 비교
        HashMap<String,Integer> result = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            String key = computer.get(i) == Integer.parseInt(String.valueOf(input.charAt(i))) ? "스트라이크" : "볼";
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
    }
}
