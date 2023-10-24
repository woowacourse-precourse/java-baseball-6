package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameManager gameManager = new GameManager();
        Computer computer = new Computer();

        do {

            List<Integer> answer = gameManager.startGame(computer);
            gameManager.playGame(answer);

        } while (gameManager.choiceRestartOrEndGame() == 1);


    }
}
