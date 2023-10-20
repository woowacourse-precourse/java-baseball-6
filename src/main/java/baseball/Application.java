package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int restartStatus;
        do {
            Play play = new Play();
            restartStatus = play.play();
        } while (restartStatus == 1);
    }
}
