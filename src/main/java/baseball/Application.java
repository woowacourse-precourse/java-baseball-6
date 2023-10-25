package baseball;

import camp.nextstep.edu.missionutils.Console;import camp.nextstep.edu.missionutils.Randoms;import java.util.ArrayList;import java.util.HashSet;import java.util.List;import java.util.Set;

public class Application {

    private static final int NUMBER_COUNT = 3; // 숫자 배열 크기 상수

    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerArray; // 컴퓨터의 숫자
        computerArray = generateComputerNumbers(); // 컴퓨터 랜덤 배열 생성

        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            validateInputCount(input);
            validateInputType(input);
            validateInputDuplicates(input);

            // 유저의 숫자 배열 생성
            List<Integer> userArray = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                userArray.add(Character.getNumericValue(input.charAt(i)));
            }

            // 볼 스트라이크 갯수 파악
            int strike = 0;
            int ball = 0;
            for (int i = 0; i < NUMBER_COUNT; i++) {
                if (computerArray.get(i).equals(userArray.get(i))) {
                    strike++;
                } else if (computerArray.contains(userArray.get(i))) {
                    ball++;
                }
            }
            printGameResult(strike, ball);

            if (isGameWon(strike, ball)) {
                if (endGameProcess()) break;
                computerArray = generateComputerNumbers();
            }
        }
        Console.close();
    }

    private static List<Integer> generateComputerNumbers() {
        List<Integer> computerArray = new ArrayList<>();
        while (computerArray.size() < NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerArray.contains(randomNumber)) {
                computerArray.add(randomNumber);
            }
        }
        return computerArray;
    }

    private static void validateInputCount(String input) {
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }

    private static void validateInputType(String input) {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
    }

    private static void validateInputDuplicates(String input) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            if (!set.add(input.charAt(i))) {
                set.clear();
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
        set.clear();
    }

    private static void printGameResult(int strike, int ball) {
        if (strike == 0 && ball == 0) { // 둘다 0인 경우
            System.out.println("낫싱");
        } else if (strike == 0) { // strike 만 0인 경우
            System.out.printf("%d볼%n", ball);
        } else if (strike != NUMBER_COUNT && ball == 0) { // ball 이 0이고 정답이 아닌 경우
            System.out.printf("%d스트라이크%n", strike);
        } else if (strike != NUMBER_COUNT) { // 위 상황을 제외하고 정답이 아닌 경우
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
        } else { // 정답에 대한 처리
            System.out.printf("%d스트라이크%n", NUMBER_COUNT);
        }
    }

    private static boolean isGameWon(int strike, int ball) {
        return strike == NUMBER_COUNT;
    }

    private static boolean endGameProcess() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", NUMBER_COUNT);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartValue = Console.readLine();
        validateRestartValue(restartValue);
        return restartValue.equals("2");
    }

    private static void validateRestartValue(String restartValue) {
        if (!restartValue.equals("1") && !restartValue.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다.");
        }
    }
}
