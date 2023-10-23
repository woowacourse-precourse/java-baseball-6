package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args)  {
        // TODO: 프로그램 구현

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        GameManager gameManager = new GameManager();
        Computer computer = new Computer();

        try{

            gameManager.startGame(computer);

        } catch (IOException e){

            throw new IllegalArgumentException(e);
        }

    }
}
