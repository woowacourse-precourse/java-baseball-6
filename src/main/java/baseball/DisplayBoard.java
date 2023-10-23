package baseball;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class DisplayBoard {

    public DisplayBoard() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    List<Integer> inputNumbers() {
        return readLine().chars()
                .mapToObj(c -> (char) c)
                .map(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
