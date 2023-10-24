package baseball.service;

import baseball.InputView.InputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final int NUMBER_LENGTH = 3;
    private List<Integer> computerNumbers;

    public BaseballGame() {
        generateComputerNumbers();
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> userNumbers = InputView.getUserNumbers();
            int[] result = checkGuess(userNumbers);
            displayResult(result);
            if (result[0] == NUMBER_LENGTH) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (restartGame()) {
                    generateComputerNumbers();
                } else {
                    break;
                }
            }
        }
    }

    private int[] checkGuess(List<Integer> userNumbers) {
        if (computerNumbers == null) {
            throw new IllegalStateException("컴퓨터 숫자가 초기화되지 않았습니다.");
        }

        int[] result = new int[2];
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                result[0]++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                result[1]++;
            }
        }
        return result;
    }

    private void displayResult(int[] result) {
        if (result[1] > 0) {
            System.out.print(result[1] + "볼 ");
        }
        if (result[0] > 0) {
            System.out.print(result[0] + "스트라이크 ");
        }
        if (result[0] == 0 && result[1] == 0) {
            System.out.print("낫싱 ");
        }
        System.out.println();
    }

    private boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        String input = Console.readLine();
        return input.equals("1");
    }

    private void generateComputerNumbers() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
    }
}
