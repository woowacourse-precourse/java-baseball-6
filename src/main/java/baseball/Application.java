package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MessagePrinter.printStartMessage();
        List<Integer> randomNumber = RandomNumberMaker.makeRandomNumber();
        System.out.println(randomNumber);
        String exit = "";
        while (!exit.equals("2")) {
            try {
                int playerNumber = GameStarter.getPlayerInput();
                int strikeCount = NumberComparer.compareNumber(playerNumber, randomNumber);

                if (strikeCount == 3) {
                    MessagePrinter.printGameEndMessage();
                    exit = RestartGameChecker.checkRestartGame();
                    randomNumber = RandomNumberMaker.makeRandomNumber();
                    System.out.println(randomNumber);
                }
            } catch (IllegalArgumentException e) {
                throw e;  // 예외 메시지 출력
            }

        }
    }
}
