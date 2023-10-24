package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    private static List<Integer> computer = new ArrayList<>();
    private static List<Integer> userNumber = Arrays.asList(0, 0, 0);
    private static int[] result = {0, 0, 0};
    // result[0] -> ball, result[1] -> strike, result[2] -> out
    private static String[] resultDisplay = {"볼", "스트라이크"};

    private static void initThreeNumbers() {
        while (computer.size() < 3) {
            computer.add(0);
        }
    }

    private static int pickingNotDuplicationNumber() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        while (computer.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9);
        }
        return randomNumber;
    }

    private static void makeThreeNumbers() {
        for (int i = 0; i < 3; i++) {
            computer.set(i, pickingNotDuplicationNumber());
        }
    }

    // 입력한 숫자가 3자리 수인지 확인
    private static void checkUserNumberThree(int number) {
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 숫자 중 0이 있는지 확인
    private static void checkIncludeZero() {
        if (userNumber.get(0) == 0) {
            throw new IllegalArgumentException();
        }
        if (userNumber.get(1) == 0) {
            throw new IllegalArgumentException();
        }
        if (userNumber.get(2) == 0) {
            throw new IllegalArgumentException();
        }
    }

    // 입력한 숫자 중 중복된 숫자가 있는지 확인
    private static void checkDuplicationUserNumber() {
        Set<Integer> isDuplicationNumbers = new HashSet<>(userNumber);
        if (isDuplicationNumbers.size() != userNumber.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void inputUserNumber() {
        int number = Integer.parseInt(Console.readLine());
        checkUserNumberThree(number);
        for (int i = 2; i > -1; i--) {
            userNumber.set(i, number % 10);
            number /= 10;
        }
        checkIncludeZero();
        checkDuplicationUserNumber();
    }

    private static void checkBallOrStrikeOrNothing(int index, int number) {
        if (computer.get(index) == number) {
            result[1]++;
            return;
        }
        if (computer.contains(number)) {
            result[0]++;
            return;
        }
        result[2]++;
    }

    private static void compareUserNumberAndComputer() {
        for (int i = 0; i < 3; i++) {
            checkBallOrStrikeOrNothing(i, userNumber.get(i));
        }
    }

    private static void notDisplayZeroInResult(int index) {
        int number = result[index];
        if (number > 0) {
            System.out.print(number + resultDisplay[index] + " ");
        }
    }

    private static void displayCompareResult() {
        if (result[2] == 3) {
            System.out.println("낫싱");
            return;
        }
        for (int i = 0; i < 2; i++) {
            notDisplayZeroInResult(i);
        }
        System.out.println();
    }

    private static void clearResult() {
        for (int i = 0; i < 3; i++) {
            result[i] = 0;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int isEnd = 1;

        System.out.println("숫자 야구 게임을 시작 합니다.");
        initThreeNumbers();
        makeThreeNumbers();

        while (isEnd == 1) {
            // 유저로부터 숫자 3자리 입력
            System.out.print("숫자를 입력해주세요 : ");
            inputUserNumber();

            // 유저가 입력한 숫자와 컴퓨터가 입력한 숫자 비교
            compareUserNumberAndComputer();
            displayCompareResult();

            if (result[1] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                isEnd = Integer.parseInt(Console.readLine());
                if (isEnd == 1) {
                    for (int i = 0; i < 3; i++) {
                        computer.set(i, 0);
                    }
                    makeThreeNumbers();
                }
                if (isEnd == 2) {
                    break;
                }
            }
            clearResult();
        }
        System.out.print(false);
    }
}