package baseball.domain.game;

import baseball.domain.Player.Player;
import baseball.domain.computer.Computer;

import java.util.Scanner;

import static baseball.domain.script.Script.GAME_START;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private Computer computer;
    private Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
        System.out.println(GAME_START.getMessage());

        while (true) {
            new GetNumbers(player, scanner);
            Compare compare = new Compare(computer, player);
            new Print(compare.strikeCount, compare.ballCount);

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
