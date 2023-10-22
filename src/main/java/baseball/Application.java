package baseball;

import java.util.Scanner;
import java.util.logging.Logger;

public class Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        do {
            Player player = new Player(Count.provideCount("123"));
            Computer computer = new Computer();
            startGame();
            inGame(sc, player, computer);
        } while (!endGame(sc));

    }

    private static boolean endGame(Scanner sc) {
        logger.info("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = sc.next();
        return input.equals("2");
    }

    private static void startGame() {
        logger.info("숫자 야구 게임을 시작합니다.");
    }

    private static void inGame(Scanner sc, Player player, Computer computer) {
        while (true) {
            String guess = getGuessNumber(sc);
            player.enterGuess(Count.provideCount(guess));
//            String gameResult = computer.judgeGameResult(player.getCount());
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

    private static String getGuessNumber(Scanner sc) {
        logger.info("숫자를 입력해주세요 : ");
        String guess = sc.next();
        return guess;
    }

}
