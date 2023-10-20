package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNums;
        List<Integer> userNums;
        List<Integer> userResult;
        boolean gameResult = false;

        computerNums = choiceComputerNums();
        printComputerNums(computerNums);

        userNums = inputUserNums();
        userResult = calculateResult(computerNums, userNums);
        gameResult = displayResult(userResult);

        if (gameResult) {
            finishGame();
        }

    }

    private static List<Integer> choiceComputerNums() {
        List<Integer> computerNums;
        computerNums = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return computerNums;
    }


    public static void printComputerNums(List<Integer> computerNums) {
        System.out.print("컴퓨터 수 = ");
        for (int computerNumber : computerNums) {
            System.out.print(computerNumber);
        }
        System.out.println();
    }

    public static List<Integer> inputUserNums() {
        List<Integer> userNums;
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        userNums = splitNum(Integer.parseInt(input));
        // 서로 다른 3개의 숫자가 아닌 예외 상황 구현

        return userNums;
    }

    private static List<Integer> splitNum(int number) {
        List<Integer> Nums = new ArrayList<>();
        Nums.add(number / 100);
        Nums.add((number / 10) % 10);
        Nums.add(number % 10);
        return Nums;
    }

    public static List<Integer> calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        List<Integer> result = new ArrayList<>();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            } else if (contains(userNumbers.get(i), computerNumbers)) {
                ball++;
            }
        }

        result.add(strike);
        result.add(ball);
        return result;
    }

    private static boolean contains(int number, List<Integer> nums) {
        for (int i : nums) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    // 스트라이크와 볼 결과 출력
    public static boolean displayResult(List<Integer> userResult) {
        int strike = userResult.get(0);
        int ball = userResult.get(1);

        if (strike == 3) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
            return true;
        }

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        return false;
    }
    public static void finishGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")){}
        else if (input.equals("2")) {
            closeSetting();
        } else {
            throw new IllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    private static void closeSetting() {
        Console.close();
        System.exit(0);
    }
}