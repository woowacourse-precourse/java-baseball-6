package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    static void pickNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    static List<Integer> readInput() {
        String input = Console.readLine();
        List<Integer> player = new ArrayList<>();

        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        for (int i = 0; i < 3; ++i) {
            int number = input.charAt(i) - '0';

            if (number < 1 || number > 9 || player.contains(number)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            player.add(number);
        }
        return player;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> player = readInput();
        List<Integer> computer = new ArrayList<>();
        pickNumber(computer);
    }
}
