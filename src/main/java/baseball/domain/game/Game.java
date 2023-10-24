package baseball.domain.game;

import static baseball.domain.script.Script.GAME_START;

import baseball.domain.Player.Player;
import baseball.domain.computer.Computer;
import java.util.Scanner;

public class Game {

    public Game() {
        Computer computer = new Computer();
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        System.out.println(GAME_START.getMessage());

        while (true) {
            new GetNumbers(player, scanner);
            Compare compare = new Compare(computer, player);
            new Printer(compare.strikeCount, compare.ballCount);

            if (compare.strikeCount == 3) {
                GameEnd gameEnd = new GameEnd(scanner);
                if (gameEnd.flag == 1) {
                    computer.resetNumbers();
                }
                if (gameEnd.flag == 2) {
                    break;
                }
            }
        }
        scanner.close();
    }
}
