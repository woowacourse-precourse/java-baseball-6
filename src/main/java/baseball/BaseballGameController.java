package baseball;

import baseball.model.GenerateRandomNumber;
import baseball.model.InputNumber;
import baseball.model.JudgementResult;
import baseball.model.RestartGame;
import java.util.List;

public class BaseballGameController {
    GenerateRandomNumber randomNumber = new GenerateRandomNumber();
    InputNumber inputNumber = new InputNumber();
    JudgementResult judgementResult = new JudgementResult();
    RestartGame restartGame = new RestartGame();
    boolean restart = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (restart) {
        List<Integer> computer = randomNumber.create();
        String result = "";
        while (!result.equals("3스트라이크")) {
            result = judgementResult.judgementResult(computer, inputNumber.playerNumber());
            System.out.println(result);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        restart = restartGame.restartGame();
    }
}
