package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> userInput() throws IllegalArgumentException {
        List<Integer> inputNumbers = new ArrayList<>();

        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        for (int i = 0; i < input.length(); i++) {
            inputNumbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }

        if (inputNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
        }

        return inputNumbers;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            Computer computer = new Computer();
            computer.generateNumbers();

            while (true) {
                GameResult gameResult = computer.verifyNumbers(userInput());
                System.out.println(gameResult.getResultString());
                if (gameResult.strike() == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
        } while (isRestart());
    }

    private boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1과 2중에서 입력해주세요.");
        }
    }
}