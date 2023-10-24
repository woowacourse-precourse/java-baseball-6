package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input_user {
    Is_right check = new Is_right();

    public List<Integer> player() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        List<Integer> num_player = new ArrayList<>();

        for (String num : input.split("")) {
            num_player.add(Integer.parseInt(num));
        }
        if (num_player.size() != 3) {
            throw new IllegalArgumentException("옳지않은 형식입니다.");
        }
        if (check.checkRight(num_player) > 0) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해 주세요");
        }
        return num_player;
    }
}
