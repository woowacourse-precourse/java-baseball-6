package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpanPlayers {
    public Player spanPlayer() {
        Player player = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해주세요 : ");

        String input = scanner.nextLine();

        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            char digitChar = input.charAt(i);
            int digit = Character.getNumericValue(digitChar);
            digits.add(digit);
        }

        player.setPlayer(digits);
        scanner.close();

        return player;
    }

    public Computer spanComputer() {
        Computer computer = new Computer();

        List<Integer> digit = new ArrayList<>();
        while (digit.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digit.contains(randomNumber)) {
                digit.add(randomNumber);
            }
        }
        computer.setComputer(digit);

        return computer;
    }
}
