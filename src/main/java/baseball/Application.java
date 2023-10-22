package baseball;

import java.util.logging.Logger;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        do {
            Player player = new Player(Count.provideCount("123"));
            Computer computer = new Computer();
            startGame();
            inGame(player, computer);
        } while (!endGame());

    }

    private static boolean endGame() {
        logger.info("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        return input.equals("2");
    }

    private static void startGame() {
        logger.info("숫자 야구 게임을 시작합니다.");
    }

    private static void inGame(Player player, Computer computer) {
        while (true) {
            String guess = getGuessNumber();
            player.enterGuess(Count.provideCount(guess));
//            String gameResult = computer.judgeGameResult(player.getGuess());
//            logger.info(gameResult);
//            if (gameOver(gameResult)) {
//                break;
//            }
        }
    }

    private static boolean gameOver(String gameResult) {
        if (gameResult.equals("3스트라이크")) {
            logger.info("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static String getGuessNumber() {
        logger.info("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

}
