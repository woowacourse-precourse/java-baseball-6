package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        Set<Integer> tempHashSet1 = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            tempHashSet1.add(input.charAt(i) - '0');
        }

        if (tempHashSet1.size() < 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        List<Integer> inputNumbers = new ArrayList<>(tempHashSet1);

        Set<Integer> tempHashSet2 = new HashSet<>();

        while (tempHashSet2.size() < 3) {
            tempHashSet2.add(Randoms.pickNumberInRange(1, 9));
        }

        List<Integer> numbers = new ArrayList<>(tempHashSet2);

        int strikeCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (inputNumbers.get(i).equals(numbers.get(i))) {
                strikeCount++;
            }
        }
    }
}
