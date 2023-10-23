package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input_user {
    //Is_right check = new Is_right();

    public List<Integer> player() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> num_player = new ArrayList<>();
        String input = Console.readLine();

        for (String num : input.split("")) {
            num_player.add(Integer.parseInt(num));
        }
        //check.checkRight(num_player);
        return num_player;
    }
}
