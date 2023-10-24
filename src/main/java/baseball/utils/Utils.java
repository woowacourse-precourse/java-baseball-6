package baseball.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private final static String OUT_OF_RANGE = "숫자 야구는 1~9까지 3자리 수만 취급 합니다.";

    // 상대방(컴퓨터)이 랜덤으로 숫자를 뽑는다.
    public static List<Integer> pickNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int com : computer) {
            System.out.println("상대방(컴퓨터) 입력 수: " + com);
        }
        return computer;
    }

    public static List<Integer> inputNumber() {
        String playerInput = Console.readLine();
        if (!digitOneToNine(playerInput)) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
        return stringToIntegerList(playerInput);
    }

    private static List<Integer> stringToIntegerList(String playerInput) {
        List<Integer> integers = new ArrayList<>();
        String[] inputSplit = playerInput.split("");
        for (String s : inputSplit) {
            integers.add(Integer.parseInt(s));
        }
        return integers;
    }

    private static boolean digitOneToNine(String playerInput) {
        int length = playerInput.length();
        return length == 3 && playerInput.matches("^[1-9]*$");
    }
}
