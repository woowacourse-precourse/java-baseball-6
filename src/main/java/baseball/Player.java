package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> player = new ArrayList<>();
        String playerNumber = Console.readLine();
        if (playerNumber.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        for (int i = 0; i < 3; i++) {
            int eachNumber = playerNumber.charAt(i) - '0';
            if (eachNumber <= 0) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            if (!player.contains(eachNumber)) {
                player.add(eachNumber);
            }
        }
        return player;
    }
}
