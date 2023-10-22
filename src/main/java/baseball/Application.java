package baseball;

import baseball.controller.BaesballGame;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BaesballGame baseballGame = new BaesballGame(sc);
        baseballGame.run();

        sc.close();
    }
}
