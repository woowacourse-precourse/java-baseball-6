package baseball;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.message.Messages.CHOOSE_RESTART;
import static baseball.message.Messages.GAME_START;
import static baseball.message.Messages.INPUT_NUMBERS;
import static baseball.message.Messages.RESULT_3_STRIKE;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();

        System.out.println(GAME_START);

        while (true) {
            System.out.print(INPUT_NUMBERS);
            List<Integer> player = new ArrayList<>();

            String input = Console.readLine();
            for (String number : input.split("")) {
                player.add(Integer.parseInt(number));
            }

            if (player.size() != 3) {
                throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
            }

            if (player.get(0) < 1
                    || player.get(0) > 9
                    || player.get(1) < 1
                    || player.get(1) > 9
                    || player.get(2) < 1
                    || player.get(2) > 9) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
            }

            if (player.get(0).equals(player.get(1))
                    || player.get(0).equals(player.get(2))
                    || player.get(1).equals(player.get(2))) {
                throw new IllegalArgumentException("중복된 숫자가 있습니다.");
            }

            String gameResultMessage = computer.getGameResultMessage(player);
            System.out.println(gameResultMessage);

            if (gameResultMessage.equals(RESULT_3_STRIKE)) {
                System.out.println(CHOOSE_RESTART);
                int restart = Integer.parseInt(Console.readLine());

                if (restart == 1) {
                    computer.generateNumbers();
                    continue;
                }
                if (restart == 2) {
                    break;
                }

                throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
            }
        }
    }
}
