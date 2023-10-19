package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class BaseballGameManager {
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isExistNextGame = true;
        while (isExistNextGame) {
            int computerNum = generateComputerNum();
            BaseballGame baseballGame = new BaseballGame(computerNum);
            isExistNextGame = startOneGame(baseballGame);
        }
    }

    private static int generateComputerNum() {
        List<Integer> nums = new LinkedList<>();

        while (nums.size() < 3) {
            int tmpNum = Randoms.pickNumberInRange(1, 9);
            if (!nums.contains(tmpNum)) {
                nums.add(tmpNum);
            }
        }

        return (nums.get(0) * 100) + (nums.get(1) * 10) + (nums.get(2));
    }

    private static boolean startOneGame(BaseballGame baseballGame) {
        while (true) {
            int inputNum = readInputNum();

            BaseballGameResult baseballGameResult = baseballGame.play(inputNum);

            System.out.println(baseballGameResult);
            if (baseballGameResult.isWin()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }

        return hasNextGame();
    }

    private static boolean hasNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1, 2이 아닌 다른 입력입니다.");
        }
    }

    private static int readInputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String line = Console.readLine();

        int num;
        try {
            num = Integer.parseInt(line);
        } catch (NumberFormatException e1) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }

        if (num > 999 || num < 100) {
            throw new IllegalArgumentException("세 자리의 숫자가 아닙니다.");
        }

        int[] numArr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();

        if (numArr[0] == numArr[1] || numArr[0] == numArr[2] || numArr[1] == numArr[2]) {
            throw new IllegalArgumentException("서로 다른 세 자리의 숫자가 아닙니다.");
        }

        return num;
    }
}
