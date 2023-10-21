package baseball;

import camp.nextstep.edu.missionutils.*;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> computerNums;
            List<Integer> userNums;
            List<Integer> userResult;
            boolean gameResult = false;

            try {
                computerNums = choiceComputerNums();
                printComputerNums(computerNums);

                while (!gameResult) {
                    userNums = inputUserNums();
                    userResult = calculateResult(computerNums, userNums);
                    gameResult = displayResult(userResult);

                    if (gameResult) {
                        finishGame();
                    }
                }

            } catch (IllegalArgumentException ex) {
                closeSetting();
            }
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
        List<Integer> userNums = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<String> userInput = splitStr(input);

        // 서로 다른 3개의 숫자가 아닌 예외 상황 구현
        if (userInput.size() != 3) {
            System.out.println("3개가 아니게 들어옴");
            throw new IllegalArgumentException("입력받은 값이 서로 다른 3개의 숫자가 아닙니다.");
        }
        if (userInput.stream().distinct().count() != userInput.size()) {
            System.out.println("서로 다르지 않음");
            throw new IllegalArgumentException("입력받은 값이 서로 다른 3개의 숫자가 아닙니다.");
        }
        if (!userInput.stream().allMatch(Application::checkNum)) {
            System.out.println("1~9를 제외한 다른값이 들어옴");
            throw new IllegalArgumentException("입력받은 값이 서로 다른 3개의 숫자가 아닙니다.");
        }

        userNums = strToNum(userInput);

        return userNums;
    }

    private static List<String> splitStr(String input) {
        String[] splitString = input.split("");

        return Arrays.asList(splitString);
    }


    private static List<Integer> strToNum(List<String> strings) {
        List<Integer> Nums = new ArrayList<>();

        for (String string : strings) {
            Nums.add(Integer.valueOf(string));
        }
        return Nums;
    }

    private static boolean checkNum(String string) {
        return string.charAt(0) >= 49 && string.charAt(0) <= 57;
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

    private static boolean contains(int num, List<Integer> nums) {
//            return nums.stream().anyMatch(n -> n.equals(num));
        for (int i : nums) {
            if (i == num) {
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

        if (input.equals("1")) {
        } else if (input.equals("2")) {
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