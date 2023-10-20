package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> answer = random3();
        List<Integer> playerInput = new ArrayList<>();
        do {
            playerInput = player3();
        }
        while (!answer.equals(playerInput));

    }

    public static List<Integer> random3() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNum)) {
                answer.add(randomNum);
            }
        }
        return answer;
    }

    public static List<Integer> player3() {
        System.out.print("숫자를 입력해주세요 : ");
        List<String> inputstr = Arrays.asList(Console.readLine().split(""));
        List<Integer> input = inputstr.stream().map(s -> Integer.parseInt(s)).toList();
        return input;
    }
}
