package baseball.domain.game;

import static baseball.domain.script.Script.GAME_END;
import static baseball.domain.script.Script.GAME_RESTART;

import java.util.Scanner;

public class GameEnd {
    int flag;

    GameEnd(Scanner scanner) {

        System.out.println(GAME_END.getMessage());
        System.out.println(GAME_RESTART.getMessage());

        int n = scanner.nextInt();
        if (n == 1) {
            flag = 1;
        }
        if (n == 2) {
            flag = 2;
        }

    }
}
