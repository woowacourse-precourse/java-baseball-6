package baseball;

import java.util.Scanner;

import static baseball.EndGame.endGame;
import static baseball.PlayGame.playGame;
import static baseball.StartGame.startGame;
import static baseball.UserDecision.userDecision;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sharedScanner = new Scanner(System.in);

        startGame();
        String userDecision;

        do {
            playGame(sharedScanner);
            userDecision = userDecision(sharedScanner);
        } while (userDecision.equals("1"));

        endGame();
    }
}
