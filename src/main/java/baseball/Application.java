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

        // 포함 여부 배열
        HashMap<Integer, Boolean> exist = new HashMap<>();

        // 정답 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (exist.getOrDefault(randomNumber,false)) continue;
            exist.put(randomNumber, true);
            computer.add(randomNumber);
        }
        System.out.println(computer);
        // 정답 입력
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$")) throw new IllegalArgumentException("서로 다른 3개의 숫자를 공백 없이 입력해 주세요.");

        // 정답 비교
        HashMap<String,Integer> result = new HashMap<>();
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            int num = computer.get(i);
            int inputNum = Integer.parseInt(String.valueOf(input.charAt(i)));
            if (!exist.getOrDefault(inputNum, false)) continue;
            String key = num == inputNum ? "스트라이크" : "볼";
            result.put(key, result.getOrDefault(key, 0) + 1);
        }

        // 결과 출력
        if (result.isEmpty()) System.out.println("낫싱");
        else {
            for (String key : result.keySet()) System.out.print(result.get(key) + key + " ");
        }

        if (result.getOrDefault("스트라이크", 0) == NUMBER_OF_DIGITS) System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
