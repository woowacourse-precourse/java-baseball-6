package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<Integer> computerNumbers;
    private int attempts = 0;

    public static void main(String[] args) {
        Application game = new Application();
        game.playGame();
    }

    public void playGame() {
        boolean newGame = true;
        while (newGame) {
            System.out.println("숫자 야구 게임을 시작합니다. 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 맞춰보세요.");
            generateComputerNumbers();
            attempts = 0;
            while (true) {
                System.out.print("숫자를 입력하세요: ");
                String userInput = Console.readLine();
                try {
                    List<Integer> userNumbers = parseUserInput(userInput);
                    if (checkDuplicate(userNumbers) || userNumbers.size() != 3) {
                        throw new IllegalArgumentException("1부터 9까지 서로 다른 수로 이루어진 3자리 숫자를 입력하세요.");
                    }
                    attempts++;
                    List<Integer> result = calculateResult(userNumbers);
                    if (result.get(0) == 3) {
                        System.out.println("3스트라이크");
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료. 시도 횟수: " + attempts);
                        break;
                    } else {
                        printResult(result);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            newGame = askForNewGame();
        }
    }

    private boolean askForNewGame() {
        System.out.print("게임을 다시 시작하시겠습니까? (1: 다시 시작, 2: 종료): ");
        String userInput = Console.readLine();
        return "1".equals(userInput);
    }

    private void generateComputerNumbers() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(number)) {
                computerNumbers.add(number);
            }
        }
    }

    private List<Integer> parseUserInput(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            int number = Character.getNumericValue(userInput.charAt(i));
            userNumbers.add(number);
        }
        return userNumbers;
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private List<Integer> calculateResult(List<Integer> userNumbers) {
        List<Integer> result = new ArrayList<>();
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (userNumbers.get(i).equals(computerNumbers.get(i))) {
                strikes++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                balls++;
            }
        }
        result.add(strikes);
        result.add(balls);
        result.add(3 - (strikes + balls));
        return result;
    }

    private void printResult(List<Integer> result) {
        System.out.println(result.get(0) + "스트라이크 " + result.get(1) + "볼 " + result.get(2) + "낫싱");
    }
}
