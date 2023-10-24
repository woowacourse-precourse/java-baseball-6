package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        printStartStmt();
        startGame();
    }

    /**
     * gameControl Methods
     */
    private static void startGame() {
        boolean restartGame;

        do {
            baseballGame();

            printAskRestartStmt();

            String restartInput = Console.readLine();
            restartGame = restartInput.equals("1");
        } while (restartGame);
    }

    private static void baseballGame() {
        List<Integer> comNums = getComNums();

        int strike = 0;
        int ball = 0;

        do {
            printInputStmt();

            List<Integer> userNums = getUserNums();

            HashMap<String, Integer> result = compareNums(comNums, userNums);
            strike = result.get("strike");
            ball = result.get("ball");

            printResult(strike, ball);
        } while (strike != 3);

        printGameEndStmt();
    }

    /**
     * input Methods
     */
    private static List<Integer> getComNums() {
        List<Integer> comNums = new ArrayList<>();
        while (comNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comNums.contains(randomNumber)) {
                comNums.add(randomNumber);
            }
        }
        return comNums;
    }

    private static List<Integer> getUserNums() {
        String input = Console.readLine();
        validateGameInput(input);

        List<Integer> userNums = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            userNums.add(input.charAt(i) - '0');
        }
        return userNums;
    }

    /**
     * utility Methods
     */
    private static HashMap<String, Integer> compareNums(List<Integer> comNums, List<Integer> userNums) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNums.size(); i++) {
            Integer cur = userNums.get(i);
            if (comNums.get(i) == cur) {
                strike++;
            } else if (comNums.contains(cur)) {
                ball++;
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("strike", strike);
        map.put("ball", ball);

        return map;
    }

    /**
     * validate Methods
     */
    private static void validateGameInput(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < 3; i++) {
            if (!input.matches("[1-9]+")) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * print Methods
     */
    private static void printStartStmt() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void printInputStmt() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private static void printGameEndStmt() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void printAskRestartStmt() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
