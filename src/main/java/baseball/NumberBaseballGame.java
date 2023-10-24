package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberBaseballGame {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    private static final List<Integer> computerNumberList = new ArrayList<>();

    public void play() {
        System.out.println(GAME_START_MESSAGE);
        while (true) {
            generateComputerNumberList();

            System.out.print(USER_INPUT_MESSAGE);
            String input = Console.readLine();

            validate(input);
            List<Integer> integers = stringToList(input);

            List<Integer> result = judge(computerNumberList, integers);
            if (isThreeStrikes(result)) {
                printResult(result);
                System.out.println(GAME_FINISH_MESSAGE);
                String userRetryInput = Console.readLine();
                if (userRetryInput.equals("1")) {
                    computerNumberList.clear();
                    continue;

                } else {
                    break;
                }
            }
            printResult(result);
        }

    }

    private static void printResult(List<Integer> result) {
        String prompt = "";
        if (result.get(1) > 0) {
            prompt += result.get(1) + BALL_MESSAGE;
        }
        if (result.get(0) > 0) {
            if (!prompt.isEmpty()) {
                prompt += " ";
            }
            prompt += result.get(0) + STRIKE_MESSAGE;
        }
        if (prompt.isEmpty()) {
            prompt = NOTHING_MESSAGE;
        }
        System.out.println(prompt);
    }

    private static boolean isThreeStrikes(List<Integer> result) {
        return result.get(0) == 3;
    }

    private static List<Integer> judge(List<Integer> computerNumberList, List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        Integer strikeCount = 0;
        Integer ballCount = 0;
        // strike first
        for (int i = 0; i < computerNumberList.size(); i++) {
            if (computerNumberList.get(i).equals(integers.get(i))) {
                strikeCount += 1;
            }
        }
        // balls
        for (int i = 0; i < computerNumberList.size(); i++) {
            for (int j = 0; j < computerNumberList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (computerNumberList.get(i).equals(integers.get(j))) {
                    ballCount += 1;
                }
            }
        }
        //
        result.add(strikeCount);
        result.add(ballCount);
        return result;
    }

    private static void validate(String input) {
        if (!input.matches("\\d{3}")) {
            throw new IllegalArgumentException();
        }
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            uniqueChars.add(c);
        }
        if (uniqueChars.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static void generateComputerNumberList() {

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }
    }

    public static List<Integer> stringToList(String str) {
        List<Integer> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) { // Only process digits
                result.add(Character.getNumericValue(c));
            }
        }
        return result;
    }
}
