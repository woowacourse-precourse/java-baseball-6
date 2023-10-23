package baseball;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class DisplayBoard {

    static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine().chars()
                .mapToObj(c -> (char) c)
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    static int inputEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(readLine());
    }
}
