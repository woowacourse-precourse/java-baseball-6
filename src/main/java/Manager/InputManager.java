package Manager;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 유저의 입력을 관리하는 클래스
 */
public class InputManager {
    // 유저의 입력을 int로 리턴
    public static int getInt() {
        return Integer.parseInt(Console.readLine());
    }

    // 유저의 입력을 string으로 리턴
    public static String getString() {
        return Console.readLine();
    }

    // string을 List<Integer>로 바꿔주는 함수
    public static List<Integer> parseInput(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
