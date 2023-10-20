package baseball;

import java.util.List;

public class BaseBallGame {

    GameInput input;
    GameService service;

    public BaseBallGame() {
        input = new GameInput();
        service = new GameService();
    }

    public void playGame() {
        List<Integer> userGuessNumber;
        List<Integer> randomNumber;
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumber = service.makeRandomNumberList();
        //TEST
        for (int i : randomNumber) {
            System.out.println(i);
        }
        //TEST END
    }
}
