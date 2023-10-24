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

    private static Balls computerNumberList;

    public void play() {
        System.out.println(GAME_START_MESSAGE);
        generateComputerNumberList();
        while (true) {
            System.out.print(USER_INPUT_MESSAGE);
            String input = Console.readLine();

            validate(input);
            List<Integer> integers = stringToList(input);
            Balls userBalls = new Balls(integers);

            Result result = Judge.judge(computerNumberList, userBalls, 3);
            printResult(result);
            if (result.getStrikeCount() == 3) {
                System.out.println(GAME_FINISH_MESSAGE);
                String userRetryInput = Console.readLine();
                if (userRetryInput.equals("1")) {
                    generateComputerNumberList();
                } else {
                    break;
                }
            }
        }

    }

    private static void printResult(Result result) {
        String prompt = "";
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();
        if (ballCount > 0) {
            prompt += ballCount + BALL_MESSAGE;
        }
        if (strikeCount > 0) {
            if (!prompt.isEmpty()) {
                prompt += " ";
            }
            prompt += strikeCount + STRIKE_MESSAGE;
        }
        if (prompt.isEmpty()) {
            prompt = NOTHING_MESSAGE;
        }
        System.out.println(prompt);
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
        List<Integer> computerSecretNumber = new ArrayList<>();
        while (computerSecretNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerSecretNumber.contains(randomNumber)) {
                computerSecretNumber.add(randomNumber);
            }
        }
        computerNumberList = new Balls(computerSecretNumber);
    }

    public static List<Integer> stringToList(String str) {
        List<Integer> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                result.add(Character.getNumericValue(c));
            }
        }
        return result;
    }
}
