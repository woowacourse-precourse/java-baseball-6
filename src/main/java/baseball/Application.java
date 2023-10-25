package baseball;

import baseball.validator.NumValidator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("야구게임을 시작합니다.");
        playBaseballGame();
        System.out.println("게임을 종료합니다.");
    }

    private static playBaseballGame() {
        try {
            String userInput = getUserInput();
            validateUserInput(userInput);

            BaseballGame game = new BaseballGame();
            game.play(userInput);

            if (shouldRestartGame()) {
                startGame();
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            if (shouldRestartGame()) {
                startGame();
            }
        }
    }

    private static String getUserInput() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    private static void validateUserInput(String input) {
        NumValidator.isInDigit(input);
        NumValidator.isInRange(input);
        NumValidator.isNumeric(input);
        NumValidator.isInRange(input);
    }

    private static boolean shouldRestartGame() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        int choice = Integer.parseInt(Console.readLine());
        return choice == 1;
    }
}
}
