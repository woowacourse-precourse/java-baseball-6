package baseball.utils;

import baseball.users.Computer;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private final static String OUT_OF_RANGE = "숫자 야구는 1~9까지 3자리 수만 입력할 수 있습니다.";
    private final static String RESTART_OR_CLOSE = "1 또는 2 숫자만 입력할 수 있습니다.";

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
        System.out.print("숫자를 입력해주세요 : ");
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

    public static int inputLastNumber() {
        String playerInput = Console.readLine();
        if (!digitOneOrTwo(playerInput)) {
            throw new IllegalArgumentException(RESTART_OR_CLOSE);
        }
        return stringToInteger(playerInput);
    }

    private static int stringToInteger(String playerInput) {
        return Integer.parseInt(playerInput);
    }

    private static boolean digitOneOrTwo(String playerInput) {
        int length = playerInput.length();
        return length == 1 && playerInput.matches("^[1-2]*$");
    }

    public static void restartOrClose(int playerInput, Computer computer) {
        if (playerInput == 1) {
            computer.changeNumbers(Utils.pickNumber());
        } else if (playerInput == 2) {
            Console.close();
        }
    }
}
