package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static boolean isPlay = false;
    private static List<Integer> randomNumbers;
    private static List<Integer> playerNumbers;

    private static void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumbers = createRandomNumber();
        while (!isPlay) {
            playerNumbers = getInputNumber();
            checkedAnswer(randomNumbers, playerNumbers);
        }
    }

    //컴퓨터 3자리 자연수 생성 함수
    private static List<Integer> createRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    private static List<Integer> getInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        checkedInputNumber(input);
        List<Integer> inputNumber = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inputNumber.add(Character.getNumericValue(input.charAt(i)));
        }

        return inputNumber;
    }

    private static void checkedAnswer(List<Integer> randomNumbers, List<Integer> userInputNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumbers.get(i).equals(userInputNumbers.get(i))) {
                strike++;
            } else if (randomNumbers.contains(userInputNumbers.get(i))) {
                ball++;
            }
        }
        printResult(ball, strike);
    }

    private static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크 ");
            }
            System.out.println();
        }
        if (strike == 3) {
            checkedRestart();
        }
    }

    private static void checkedRestart() {
        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = Console.readLine();
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("입력값이 시작 1, 종료 2가 아니므로 종료합니다.");
        }

        if (input.equals("1")) {
            isPlay = false;
            randomNumbers = createRandomNumber();
        } else {
            isPlay = true;
        }
    }

    private static void checkedInputNumber(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리가 아니므로 종료합니다.");
        }
        if (!input.matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException("입력값이 올바르지 않아 종료합니다.");
        }
        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(
                2)) {
            throw new IllegalArgumentException("중복된 값이 존재하므로 종료합니다.");
        }
    }

    public static void main(String[] args) {
        play();
        // TODO: 프로그램 구현
    }
}
