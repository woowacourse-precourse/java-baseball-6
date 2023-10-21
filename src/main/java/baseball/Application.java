package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class Application {

    public Application() {

    }

    public static void main(String[] args) {
        startGame();
    }

    enum PlayResult {
        BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

        PlayResult(String text) {
            this.label = text;
        }

        private final String label;

        public String getLabel() {
            return this.label;
        }
    }

    public static void startGame() {
        boolean flag = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (flag) {
            playGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            flag = isRestartGame();
        }
        Console.close();
    }

    private static void playGame() {
        List<Integer> computerNumbers = generateComputerNumbers();

        boolean isAnswerRight = false;
        while (!isAnswerRight) {
            List<Integer> userNumbers = requestUserNumbers();
            Map<PlayResult, Integer> gameResult = new HashMap<>();

            for (int index = 0; index < computerNumbers.size(); index++) {
                int computerNumber = computerNumbers.get(index);
                PlayResult playResult = compareComputerAndUserNumbers(computerNumber, userNumbers, index);
                gameResult.put(playResult, gameResult.getOrDefault(playResult, 0) + 1);
            }

            printGameResultMessage(gameResult);
            isAnswerRight = checkAnswer(gameResult);
        }
    }

    private static List<Integer> generateComputerNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    private static List<Integer> requestUserNumbers() {
        System.out.print("숫자를 입력해 주세요 : ");
        String input = Console.readLine();
        validateInput(input);
        return convertStringToList(input);
    }

    private static void validateInput(String input) {
        isThreeDigit(input);
        isUniqueNumbers(input);
    }

    private static void isThreeDigit(String input) {
        if (!Pattern.matches("^\\d{3}$", input)) {
            throw new IllegalArgumentException("3자리의 수가 아닙니다.");
        }
    }

    private static void isUniqueNumbers(String input) {
        Set<Character> numbers = new HashSet<>();
        for (char number : input.toCharArray()) {
            numbers.add(number);
        }

        if (numbers.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리의 수가 아닙니다.");
        }
    }

    private static List<Integer> convertStringToList(String input) {
        List<Integer> list = new ArrayList<>();
        for (Character character : input.toCharArray()) {
            list.add(convertCharToInt(character));
        }
        return list;
    }

    private static int convertCharToInt(Character character) {
        return character - '0';
    }

    private static PlayResult compareComputerAndUserNumbers(int computerNumber, List<Integer> userNumbers, int index) {
        if (isNothing(computerNumber, userNumbers)) {
            return PlayResult.NOTHING;
        }

        if (isStrike(userNumbers.get(index), computerNumber)) {
            return PlayResult.STRIKE;
        }

        return PlayResult.BALL;
    }

    private static boolean isNothing(int computerNumber, List<Integer> userNumbers) {
        return !userNumbers.contains(computerNumber);
    }

    private static boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
    }

    private static boolean checkAnswer(Map<PlayResult, Integer> gameResult) {
        if (isRight(gameResult)) {
            return true;
        }
        return false;
    }

    private static boolean isRight(Map<PlayResult, Integer> gameResult) {
        if (!gameResult.containsKey(PlayResult.STRIKE)) {
            return false;
        }
        return gameResult.get(PlayResult.STRIKE) == 3;
    }

    private static void printGameResultMessage(Map<PlayResult, Integer> gameResult) {
        String gameResultMessage = generateGameResultMessage(gameResult);
        System.out.println(gameResultMessage);
    }


    private static String generateGameResultMessage(Map<PlayResult, Integer> gameResult) {
        StringBuilder stringBuilder = new StringBuilder();

        if (
            gameResult.containsKey(PlayResult.NOTHING) &&
            gameResult.get(PlayResult.NOTHING) == 3
        ) {
            stringBuilder.append(PlayResult.NOTHING.getLabel());
            return stringBuilder.toString();
        }

        Arrays.sort(gameResult.keySet().toArray());

        for (Entry<PlayResult, Integer> playResultIntegerEntry : gameResult.entrySet()) {
            if (playResultIntegerEntry.getKey() == PlayResult.NOTHING) {
                continue;
            }

            stringBuilder
                    .append(playResultIntegerEntry.getValue())
                    .append(playResultIntegerEntry.getKey().getLabel())
                    .append(" ");
        }

        return stringBuilder.toString().trim();
    }


    private static boolean isRestartGame() {
        int input = readUserInput();
        validateInput(input);
        return input == 1;
    }

    private static int readUserInput() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }
    }

    private static void validateInput(int input) {
        if (input != 1 && input != 2) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }
    }
}

