package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean playAgain = true;

        while (playAgain) {
            Game game = new Game();
            playGame(game);
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
            int choice = Integer.parseInt(Console.readLine());

            if (choice == 2) {
                playAgain = false;
            }
        }
    }

    private static void playGame(Game game) {
        System.out.println("서로 다른 3자리의 숫자를 입력해주세요.");

        while (true) {
            System.out.print("숫자를 입력해주세요: ");
            String input = Console.readLine();
            try {
                List<Integer> userGuess = parseUserInput(input);
                int[] result = game.playRound(userGuess);

                if (result[0] == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (result[0] == 0) {
                    System.out.println("낫싱");
                } else {
                    if (result[1] == 0) {
                        System.out.println(result[0] + "스트라이크");
                    } else {
                        System.out.println(result[1] + "볼 " + result[0] + "스트라이크");
                    }
                }
            } catch (IllegalArgumentException e) {
                System.err.println("잘못된 입력입니다. 3자리 서로 다른 숫자를 입력해주세요.");
            }
        }
    }

    private static List<Integer> parseUserInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 3자리 숫자여야 합니다.");
        }

        List<Integer> userGuess = new ArrayList<>();
        for (char digit : input.toCharArray()) {
            int num = Character.getNumericValue(digit);
            if (userGuess.contains(num) || num < 1 || num > 9) {
                throw new IllegalArgumentException("입력은 3자리 서로 다른 숫자여야 합니다.");
            }
            userGuess.add(num);
        }
        return userGuess;
    }
}
