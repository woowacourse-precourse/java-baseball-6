package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        StartGame startGame = new StartGame();

        while (startGame.isGameActive()){
            startGame.run();
            RetryGame retryGame = new RetryGame(startGame);
            retryGame.retryByRequest(Console.readLine());
        }
    }


}
