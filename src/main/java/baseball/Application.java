package baseball;

import java.util.List;

public class Application {
    private static final String RESTART_CODE = "1";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String exit = "";
        do {
            MessagePrinter.printStartMessage();
            List<Integer> answer = RandomNumberMaker.makeRandomNumber();

            BaseballGame baseballGame = new BaseballGame(answer);
            baseballGame.play();

            exit = RestartGameChecker.checkRestartGame();
        }
        while (RESTART_CODE.equals(exit));
    }
}
