package baseball;

import baseball.domain.Hint;
import baseball.domain.RestartCommand;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.view.BaseballApplicationConsoleMessage.*;

public class Application {
    public static void main(String[] args) {
        System.out.println(GAME_START);

        while (true) {
            List<Integer> computerNumbers = new ArrayList<>();
            while (computerNumbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computerNumbers.contains(randomNumber)) {
                    computerNumbers.add(randomNumber);
                }
            }

            while (true) {
                Hint.initialize();
                System.out.print(INPUT_PLAYER_NUMBER);

                String inputNumber = Console.readLine();
                if (!inputNumber.matches("^[123456789]{3}$")) {
                    throw new IllegalArgumentException("올바르지 않은 입력값 입니다.");
                }
                List<Integer> toList = Arrays.stream(inputNumber.split(""))
                        .map(Integer::parseInt)
                        .toList();
                HashSet<Integer> set = new HashSet<>(toList);
                if (set.size() != 3) {
                    throw new IllegalArgumentException("올바르지 않은 입력값 입니다.");
                }

                for (int i = 0; i < 3; i++) {
                    if (computerNumbers.contains(toList.get(i))) {
                        if (computerNumbers.get(i).equals(toList.get(i))) {
                            Hint.STRIKE.addCount();
                            continue;
                        }
                        Hint.BALL.addCount();
                    }
                }

                System.out.println(Hint.getResultMessage());
                if (Hint.isWin()) {
                    System.out.println(GAME_END);
                    break;
                }
            }

            System.out.println(GAME_RESTART);

            String command = Console.readLine();
            if (RestartCommand.isExit(command)) {
                break;
            }
        }
    }
}
