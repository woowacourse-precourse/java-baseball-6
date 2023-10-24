package baseball;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGame game = new BaseballGame(sc);
        game.play();
        sc.close();
    }
}
