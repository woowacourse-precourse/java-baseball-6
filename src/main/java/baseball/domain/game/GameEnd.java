package baseball.domain.game;

import java.util.Scanner;

import static baseball.domain.script.Script.*;

public class GameEnd {
    int flag;

    GameEnd(Scanner scanner) {

        System.out.println(GAME_END.getMessage());
        System.out.println(GAME_RESTART.getMessage());

        int n = scanner.nextInt();
        if (n == 1) {
            flag = 1;
        }
        if (n == 2) flag = 2;

    }
}
