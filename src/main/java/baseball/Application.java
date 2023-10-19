package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int MAX_LENGTH = 3;

    public static void main(String[] args) {
        gameProcess();
    }

    public static void gameProcess() {
        List<Integer> computerNum = getRandomNumber();
        checkGame(computerNum);
    }

    public static List<Integer> getRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println(computer);
        return computer;
    }

    public static List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }

        BaseballException.numListSize(numbers, MAX_LENGTH);
        return numbers;
    }

    public static void checkGame(List<Integer> computer) {
        while (true) {
            List<Integer> user = getUserInput();
            int ballCount = 0;
            int strikeCount = 0;

            for (int i = 0; i < MAX_LENGTH; i++) {
                if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                    ballCount++;
                }
                if (computer.get(i).equals(user.get(i))) {
                    strikeCount++;
                }
            }

            if (strikeCount == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                if (selectExit())
                    gameProcess();
                return;
            }

            if (ballCount > 0) {
                System.out.println(ballCount + "볼 ");
            }

            if (strikeCount > 0) {
                System.out.println(strikeCount + " 스트라이크 ");
            }

            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
            }
        }
    }

    public static boolean selectExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        return choice == 1;
    }
}
