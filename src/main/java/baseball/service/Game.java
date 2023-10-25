package baseball.service;

import baseball.model.Computer;
import baseball.model.Score;
import baseball.view.Result;
import camp.nextstep.edu.missionutils.Console;

public class Game {
    private static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESASGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void start() {
        Computer computer = new Computer();
        Score score;
        do {
            Inning inning = new Inning();
            score = inning.doInning(computer);
            Result result = new Result(score);
            result.printMessages();
        } while (!score.isCleared());
    }

    public boolean restart() {
        printRestartMessage();
        String answer = getAnswer();
        validateAnswer(answer);
        return Integer.valueOf(answer) == 1;

    }

    public void clear() {
        printClearMessage();
    }

    private void validateAnswer(String answer) {
        if (!answer.matches("^[1-2]*$")) {
            throw new IllegalArgumentException("답은 1이나 2로 선택하세요.");
        }
    }

    private String getAnswer() {
        return Console.readLine().trim();
    }

    private void printRestartMessage() {
        System.out.println(RESTART_MESASGE);
    }

    private void printClearMessage() {
        System.out.println(GAME_CLEAR_MESSAGE);
    }

    private boolean isCleared(Score score) {
        return score.getStrike() == 3;
    }


}
