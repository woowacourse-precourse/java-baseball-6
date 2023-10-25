package baseball;

import java.util.List;

public class Application {
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
        while (exit.equals("1"));
    }
}
