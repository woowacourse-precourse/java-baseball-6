package baseball.domain.controller;

import baseball.domain.util.generator.ComputerGenerate;
import baseball.domain.util.generator.UserGenerate;
import baseball.domain.view.input.UserInput;
import baseball.domain.view.output.GameProcessingPrinter;
import java.util.List;

public class BaseballGame {
    public void gameStart() {
        GameProcessingPrinter.printGameStart();
        do {
            ComputerGenerate computerGenerate = new ComputerGenerate();

            // 컴퓨터 랜덤 수 생성
            List<Integer> target = computerGenerate.getTarget();

            // 플레이어 입력 및 게임 로직
            play(target);
        } while (!isEnd());
    }

    private void play(List<Integer> target) {
        while (!isCorrectAttempt(target)) {
        }
    }

    private boolean isCorrectAttempt(List<Integer> target) {
        UserGenerate userGenerate = new UserGenerate();
        GameRule gameRule = new GameRule();

        // 사용자 3개의 숫자 입력
        List<Integer> attempt = userGenerate.getAttempt();

        // 사용자 입력 마다의 결과
        if (gameRule.gameLogic(attempt, target)) {
            return true;
        }
        return false;
    }

    private boolean isEnd() {
        UserInput userInput = new UserInput();

        GameProcessingPrinter.printGameEnd();
        String input = userInput.getEndGameInput();
        if (input.equals("1")) {
            return false;
        }
        return true;
    }
}
