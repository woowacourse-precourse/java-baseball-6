package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {


    private List<Integer> computerNumbers;
    public void start() {
        do {
            computernumbers();
            playGame();
        } while (isContinue());
    }

    private void computernumbers() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }
    }
    private void playGame() {
        boolean isCorrect;
        do {
            List<Integer> userNumbers = getUserInput();
            isCorrect = checkNumbers(userNumbers);
        } while (!isCorrect);
    }

    private List<Integer> getUserInput() {
        List<Integer> userNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 값은 " + 3 + "자리 숫자여야 합니다.");
        }
        for (char c : input.toCharArray()) {
            userNumbers.add(Character.getNumericValue(c));
        }
        return userNumbers;
    }


    private boolean checkNumbers(List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }
        printResult(strike, ball);
        return strike == 3;
    }

    private void printResult(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else {
            System.out.println( ball + "볼 " + strike + "스트라이크");
        }
    }

    private boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return "1".equals(input);
    }


    public static void main(String[] args) {
        System.out.println("게임을 시작합니다");
        new Application().start();
    }
}
