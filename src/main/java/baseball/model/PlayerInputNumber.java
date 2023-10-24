package baseball.model;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

// 2. 사용자 입력 받기
public class PlayerInputNumber {
    public static String playerInput() {
        OutputView.printInputNumMessage();
        String input = Console.readLine();

        return input;
    }

    public static List<Integer> inputNumberList(String input) {
        List<Integer> playerNum = new ArrayList<>();

        for (String number : input.split("")) {
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }

    public static String restartOrEnd(){
        OutputView.printRestartMessage();

        return Console.readLine();
    }
}
