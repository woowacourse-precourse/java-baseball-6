package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    public static void playGame() {
        List<Integer> computerNums;
        List<Integer> userNums;
        List<Integer> userResult;
        boolean gameResult = false;

        computerNums = choiceComputerNums();

        while (!gameResult) {
            userNums = inputUserNums();
            userResult = calculateResult(computerNums, userNums);
            gameResult = displayResult(userResult);

            if (gameResult) {
                finishGame();
            }
        }
    }

    private static List<Integer> choiceComputerNums() {
        Set<Integer> computerNums = new HashSet<>();
        while (computerNums.size() < 3) {
            computerNums.add(Randoms.pickNumberInRange(1, 9));
        }

        return new ArrayList<>(computerNums);
    }


    public static List<Integer> inputUserNums() {
        List<Integer> userNums;

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        List<String> userInput = splitStr(input);

        //공백과 함께 입력했을 시, 공백을 제외하고 나머지 입력에서 판단을 해주는 기능
        userInput = userInput.stream()
                .filter(str -> !str.equals(" ")).toList();

//      3개가 아니게 들어 왔을 경우 예외 터뜨림
        if (userInput.size() != 3) {
            makeIllegalArgumentException("입력받은 값이 서로 다른 3개의 숫자가 아닙니다.");
        }
//       서로 다르지 않을 경우 예외 터뜨림
        if (userInput.stream()
                .distinct()
                .count() != userInput.size()) {
            makeIllegalArgumentException("입력받은 값이 서로 다른 3개의 숫자가 아닙니다.");
        }
//      1~9를 제외한 다른 값이 들어와서 예외 터뜨림
        if (!userInput.stream()
                .allMatch(Application::checkNum)) {
            makeIllegalArgumentException("입력받은 값이 서로 다른 3개의 숫자가 아닙니다.");
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
        return string.matches("[1-9]");
    }

    private static void makeIllegalArgumentException(String s) {
        close();
        throw new IllegalArgumentException(s);
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
        return nums.stream()
                .anyMatch(n -> n.equals(num));
    }

    // 스트라이크와 볼 결과 출력
    public static boolean displayResult(List<Integer> userResult) {
        int strike = userResult.get(0);
        int ball = userResult.get(1);

        if (strike == 3) {
            System.out.print("3스트라이크\n");
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

        switch (input) {
            case "1":
                playGame();
                break;
            case "2":
                close();
                break;
            default:
                makeIllegalArgumentException("게임을 새로 시작하려면 1, 종료하려면 2를 입력해야합니다.");
        }
    }

    private static void close() {
        Console.close();
    }
}