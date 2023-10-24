package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // computer
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // user
        System.out.println("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해 주세요.");
        }
        List<Integer> userNumber = new ArrayList<>();
        Set<Integer> userNumberSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            int num = Character.getNumericValue(ch);
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자를 입력해주세요.");
            }
            userNumber.add(num);
            userNumberSet.add(num);
        }

        if (userNumber.size() != userNumberSet.size()) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해주세요.");
        }

        System.out.println(1 + "볼 " + 1 + "스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        System.out.println("게임을 종료합니다.");
    }
}
