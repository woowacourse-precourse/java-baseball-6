package baseball;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        BufferedReader receiver = new BufferedReader(new InputStreamReader(System.in));

        GameManager gameManager = new GameManager(receiver);
        gameManager.run();
    }
}
