package baseball.Game;

import baseball.Computer.ComputerGenerate;
import baseball.User.Input.UserInput;
import baseball.User.UserGenerate;

import java.util.List;

public class BaseballGame {
    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> target;
            ComputerGenerate computerGenerate = new ComputerGenerate();

            target = computerGenerate.getTarget();
            play(target);
            if (isEnd()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    private void play(List<Integer> target) {
        while (true) {
            List<Integer> attempt;
            UserGenerate userGenerate = new UserGenerate();
            GameRule gameRule = new GameRule();

            attempt = userGenerate.getAttempt();
            if (gameRule.gameLogic(attempt, target)) {
                break;
            }
        }
    }

    private boolean isEnd() {
        String input;
        UserInput userInput = new UserInput();
        input = userInput.getEndGameInput();
        if (input.equals("1")) {
            return false;
        }
        return true;
    }
}
