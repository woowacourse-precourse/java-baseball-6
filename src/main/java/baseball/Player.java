package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static boolean isFirst = true;
    private static List<Integer> playerNumber;

    public static void inputNumber() {
        if (isFirst) {
            System.out.println(START_MESSAGE);
        }
        isFirst = false;
        System.out.print(INPUT_MESSAGE);

        playerNumber = new ArrayList<>();
        String input = Console.readLine();
        isException(input);
        String[] strings = input.split("");

        for (String s : strings) {
            playerNumber.add(Integer.valueOf(s));
        }
    }

    public static List<Integer> getPlayerNumber() {
        inputNumber();
        return playerNumber;
    }

    public static boolean isRerun() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1또는 2만 입력하세요.");
        }
    }

    public static void isException(String str) {
        Set<String> set = new HashSet<>(Arrays.asList(str.split("")));
        if (!str.matches("[1-9]{3}") || set.size() != 3) {
            throw new IllegalArgumentException("0이 아닌 3자리의 서로 다른 수를 입력하세요.");
        }
    }
}
