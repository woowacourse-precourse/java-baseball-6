package baseball;

import java.util.List;

public class BaseBallGame {

    GameInput input;

    public BaseBallGame() {
        input = new GameInput();
    }

    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> userGuessNumber;
        // Test
        userGuessNumber = input.UserInputGuessNumber();
        for (int i : userGuessNumber) {
            System.out.println(i);
        }
        // Test End
    }
}
