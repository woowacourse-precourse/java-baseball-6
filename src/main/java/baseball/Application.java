package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean playAgain = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (playAgain) {
            Game game = new Game();
            while (!game.isGameOver()) {
                System.out.print("숫자를 입력해주세요 :");
                String input = Console.readLine();
                try {
                    String result = game.play(input);
                    System.out.println(result);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException();
                }
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int choice = Integer.parseInt(Console.readLine());
            if (choice == 2) {
                playAgain = false;
            }
        }
    }
}

class Game {
    private final int[] answer;
    private boolean gameOver;

    public Game() {
        this.answer = generateRandomNumber();
        this.gameOver = false;
    }

    private int[] generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = computer.get(i);
        }
        return numbers;
    }

    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String play(String input) {
        if (input.length() != 3 || !input.matches("[1-9]+")) {
            throw new IllegalArgumentException();
        }

        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            guess[i] = input.charAt(i) - '0';
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                strikes++;
            } else if (contains(answer, guess[i])) {
                balls++;
            }
        }

        String result = getResultString(strikes, balls);

        if (strikes == 3) {
            gameOver = true;
        }

        return result;
    }

    private String getResultString(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return "낫싱";
        }
        return  (balls > 0 ? balls + "볼" : "")+ (strikes > 0 && balls > 0 ? " " : "") +
                (strikes > 0 ? strikes + "스트라이크" : "");
    }
}