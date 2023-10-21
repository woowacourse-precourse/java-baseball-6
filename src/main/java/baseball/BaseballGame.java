package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
    private static final String RESTART_GAME = "1";
    private static final String QUIT_GAME = "2";
    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (playGame()) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String reGame = Console.readLine();
            if (reGame.equals(QUIT_GAME)) {
                return;
            }
            if (!reGame.equals(RESTART_GAME)) {
                throw new IllegalArgumentException("올바른 입력이 아닙니다.");
            }
        }
    }

    private static boolean playGame() {
        List<Integer> answer = AnswerGenerator.generateAnswer();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> guess = InputValidator.validateInput(input);
            int[] result = StrikeBallCalculator.calculate(guess, answer);
            String message = GameResultMessage.generateResultMessage(result);
            System.out.println(message);

            if (message.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
        }
    }
}
