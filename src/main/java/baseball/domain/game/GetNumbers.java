package baseball.domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseball.domain.Player.Player;

import static baseball.domain.script.Script.NUMS_INPUT;

public class GetNumbers {
    GetNumbers(Player player, Scanner scanner) {
        System.out.print(NUMS_INPUT.getMessage());

        List<Integer> list = new ArrayList<>();
        String tmp = scanner.next();
        if (tmp.length() > 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            list.add(tmp.charAt(i) - '0');
        }
        player.setNumbers(list);
    }
}
