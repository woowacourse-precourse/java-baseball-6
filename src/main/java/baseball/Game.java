package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Computer computer;

    public Game() {
        this.computer = new Computer();
    }

    public void start() {
        System.out.println(START_MESSAGE);
        while (true) {
            List<Integer> playerNumbers = inputNumbers();
            Result result = new Result(computer.getNumbers(), playerNumbers);
            printResult(result);
            if (result.getStrikes() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                if (!askForRestart()) {
                    break;
                }
            }
        }
    }

    private List<Integer> inputNumbers() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        return parseInput(input);
    }

    private List<Integer> parseInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리의 수를 입력해주세요.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }

    private void printResult(Result result) {
        if (result.getBalls() == 0 && result.getStrikes() == 0) {
            System.out.println("낫싱");
            return;
        }
        if (result.getBalls() > 0) {
            System.out.print(result.getBalls() + "볼 ");
        }
        if (result.getStrikes() > 0) {
            System.out.print(result.getStrikes() + "스트라이크");
        }
        System.out.println();
    }

    private boolean askForRestart() {
        System.out.println(RESTART_MESSAGE);
        String input = Console.readLine();
        if (input.equals("1")) {
            computer = new Computer();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Game().start();
    }
}
