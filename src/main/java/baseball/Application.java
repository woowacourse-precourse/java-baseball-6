package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    private static final int MAX_LENGTH = 3;

    public static void main(String[] args) {
        List<Integer> computerNum = getRandomNumber();
        List<Integer> numbersNum = getUserInput();

        checkBall(computerNum, numbersNum);
        checkStrike(computerNum, numbersNum);
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

    public static void checkBall(List<Integer> computer, List<Integer> user) {
        int ballCount = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (computer.contains(user.get(i)) && !computer.get(i).equals(user.get(i))) {
                ballCount++;
            }
        }
        System.out.print(ballCount + "볼 ");
    }

    public static void checkStrike(List<Integer> computer, List<Integer> user) {
        int strikeCount = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (computer.get(i).equals(user.get(i))) {
                strikeCount++;
            }
        }
        System.out.print(strikeCount + "스트라이크 ");

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
        }
    }
}
