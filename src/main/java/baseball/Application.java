package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int GAME_LENGTH = 3;
    private List<Integer> computerNumbers;

    public Application() {
        computerNumbers = generateComputerNumbers();
    }

    public static void main(String[] args) {
        Application game = new Application();
        game.run();
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < GAME_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isGameOver = false;

        while (!isGameOver) {
            List<Integer> userNumbers = getUserNumbers();
            String result = calculateResult(userNumbers);
            System.out.println(result);
            isGameOver = result.equals("3스트라이크");

            if (isGameOver) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
                String input = Console.readLine();

                if ("1".equals(input)) {
                    computerNumbers = generateComputerNumbers();
                    isGameOver = false;
                }
            } else {
                System.out.print("숫자를 입력해주세요 : ");
            }

        }
    }


    private List<Integer> getUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return parseInput(input);
    }

    private List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        if (input.length() != GAME_LENGTH) {
            throw new IllegalArgumentException("숫자는 3개를 입력해주세요");
        }

        for (char digit : input.toCharArray()) {
            int number = Character.getNumericValue(digit);
            if (number < 1 || number > 9 || numbers.contains(number)) {
                throw new IllegalArgumentException("1에서 9까지의 '서로 다른 숫자' 3개를 입력하세요.");
            }
            numbers.add(number);
        }

        return numbers;
    }

    private String calculateResult(List<Integer> userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < GAME_LENGTH; i++) {
            int userNumber = userNumbers.get(i);
            int computerNumber = computerNumbers.get(i);

            if (userNumber == computerNumber) {
                strikes++;
            } else if (computerNumbers.contains(userNumber)) {
                balls++;
            }
        }

        if (strikes > 0 && balls > 0) {
            return String.format("%d볼 %d스트라이크", balls, strikes);
        } else if (strikes > 0) {
            return String.format("%d스트라이크", strikes);
        } else if (balls > 0) {
            return String.format("%d볼", balls);
        } else {
            return "낫싱";
        }
    }
}
