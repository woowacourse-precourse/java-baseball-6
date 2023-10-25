package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            playGame();
            if (!playAgain()) {
                break;
            }
        }
    }

    private static void playGame() {
        List<Integer> answerList = generateRandomNumberList(1, 9, 3); // 정답 생성

        while (true) { // 게임 진행
            String input = getInputFromUser("숫자를 입력해주세요 : "); // 사용자 입력

            if (input.length() != 3) { // 입력값 예외처리
                throw new IllegalArgumentException("숫자는 3자리만 입력 가능합니다.");
            }

            List<Integer> inputList = parseInput(input);

            int[] result = calculateResult(inputList, answerList);
            printResult(result);

            if (result[0] == 3) { // 정답일 경우
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private static List<Integer> generateRandomNumberList(int min, int max, int size) {
        List<Integer> randomList = new ArrayList<>();

        while (randomList.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            if (!randomList.contains(randomNumber)) {
                randomList.add(randomNumber);
            }
        }

        return randomList;
    }

    private static String getInputFromUser(String message) {
        System.out.print(message);
        return Console.readLine();
    }

    private static List<Integer> parseInput(String input) {
        List<Integer> inputList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            inputList.add(Integer.parseInt(input.substring(i, i + 1)));
        }
        return inputList;
    }

    private static int[] calculateResult(List<Integer> inputList, List<Integer> answerList) {
        int[] result = new int[2]; // result[0] = strike, result[1] = ball
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputList.get(i).equals(answerList.get(j))) {
                    if (i == j) {
                        result[0]++; // Strike
                    } else {
                        result[1]++; // Ball
                    }
                }
            }
        }
        return result;
    }

    private static void printResult(int[] result) {
        if (result[0] == 0 && result[1] == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
        }
    }

    private static boolean playAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        return restart.equals("1");
    }
}
