package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            List<Integer> target = game.getTargetNumber();
            System.out.println(target);
            while (true) {
                List<Integer> input = game.getUserInput();

                int strikes = game.getStrikes(input, target);
                int balls = game.getBalls(input, target);
                game.printResult(strikes, balls);

                if (game.isGameEnd(strikes)) {
                    break;
                }

            }
        } while (game.playAgain());
    }
}
