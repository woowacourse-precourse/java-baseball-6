package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {

    private static final int INPUT_MESSAGE_LENGTH = 3;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_CONTAIN_BLANK_EXCEPTION = "공백은 입력할 수 없습니다.";
    private static final String INPUT_NUMBER_IS_NOT_DIGIT_EXCEPTION = "1에서 9까지의 숫자만 입력하세요.";
    private static final String INPUT_NUMBER_CONTAIN_ZERO_EXCEPTION = "0을 포함할 수 없습니다.";
    private static final String INPUT_NUMBER_LENGTH_EXCEPTION = "3자리의 숫자만 입력하세요.";
    private static final String INPUT_NUMBER_IS_DUPLICATE_NUMBER_EXCEPTION = "서로 다른 숫자를 입력하세요.";
    private static final String INPUT_NUMBER_IS_NOT_ONE_OR_TWO = "1또는 2만 입력하세요.";
    private static final String ZERO_VALUE = "0";
    private static final String RERUN_VALUE = "1";
    private static final String QUIT_VALUE = "2";
    private static final String BLANK = " ";
    private static final String NOT_DIGIT_REGEX = "\\D+";
    private static boolean isFirst = true;
    private static List<Integer> playerNumber;

    public static void inputNumber() {
        if (isFirst) {
            System.out.println(GAME_START_MESSAGE);
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

    public static boolean isRestart() {
        System.out.println(RESTART_OR_QUIT_MESSAGE);
        String input = Console.readLine();
        if (input.equals(RERUN_VALUE)) {
            return true;
        }
        if (input.equals(QUIT_VALUE)) {
            return false;
        }
        throw new IllegalArgumentException(INPUT_NUMBER_IS_NOT_ONE_OR_TWO);
    }

    public static void isException(String str) {
        Set<String> set = new HashSet<>(Arrays.asList(str.split("")));
        Matcher matcher = Pattern.compile(NOT_DIGIT_REGEX).matcher(str);
        if (str.contains(BLANK)) {
            throw new IllegalArgumentException(INPUT_NUMBER_CONTAIN_BLANK_EXCEPTION);
        }
        if (matcher.find()) {
            throw new IllegalArgumentException(INPUT_NUMBER_IS_NOT_DIGIT_EXCEPTION);
        }
        if (str.contains(ZERO_VALUE)) {
            throw new IllegalArgumentException(INPUT_NUMBER_CONTAIN_ZERO_EXCEPTION);
        }
        if (str.length() != INPUT_MESSAGE_LENGTH) {
            throw new IllegalArgumentException(INPUT_NUMBER_LENGTH_EXCEPTION);
        }
        if (set.size() != INPUT_MESSAGE_LENGTH) {
            throw new IllegalArgumentException(INPUT_NUMBER_IS_DUPLICATE_NUMBER_EXCEPTION);
        }
    }
}