package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int DIGIT_COUNT = 3;

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (playGame()) {
                break;
            }
        }
    }

    private static boolean playGame() {
        List<Integer> computerNumbers = getRandomNumber();

        List<Integer> userNumbers;
        do {
            userNumbers = getUserNumbers();
            int[] result = calculateResult(computerNumbers, userNumbers);
            printResult(result);
        } while (!isGameOver(userNumbers, computerNumbers));

        return !wantsToPlayAgain();
    }

    public static ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> answerNumberList = new ArrayList<>();

        while (answerNumberList.size() < DIGIT_COUNT) {
            checkExistsInList(Randoms.pickNumberInRange(1, 9), answerNumberList);
        }
        return answerNumberList;
    }

    public static void checkExistsInList(int number, ArrayList<Integer> list) {
        if (!list.contains(number)) {
            list.add(number);
        }
    }

    private static List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return parseUserNumbers(input);
    }

    private static List<Integer> parseUserNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        if (input.length() != DIGIT_COUNT) {
            throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
        }

        for (int i = 0; i < DIGIT_COUNT; i++) {
            int number = Character.getNumericValue(input.charAt(i));
            if (number < 1 || number > 9 || numbers.contains(number)) {
                throw new IllegalArgumentException("1부터 9까지 서로 다른 숫자만 입력해야 합니다.");
            }
            numbers.add(number);
        }

        return numbers;
    }


    private static int calculateBalls(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int balls = 0;

        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                continue; // 동일한 위치의 숫자는 볼이 아니므로 다음으로 넘어감
            }

            if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }

        return balls;
    }

    private static int[] calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strikes = 0;
        int balls = calculateBalls(computerNumbers, userNumbers);

        for (int i = 0; i < DIGIT_COUNT; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            }
        }

        return new int[]{strikes, balls};
    }

    private static void printResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        String output = "";


        if (balls > 0 && strikes > 0) {
            output += balls + "볼 ";
            output += strikes + "스트라이크";
        }

        else if (strikes > 0) {
            output += strikes + "스트라이크";
        }

        else if (balls > 0) {
            output += balls + "볼";
        }

        else {
            //if (strikes == 0 && balls == 0) {
            output = "낫싱";
        }

        System.out.println(output);
    }

    private static boolean isGameOver(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return userNumbers.equals(computerNumbers);
    }

    private static boolean wantsToPlayAgain() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        String input = Console.readLine();
        if (!"2".equals(input) && !"1".equals(input)) {
            throw new IllegalArgumentException();
        }
        return "1".equals(input);
    }


}