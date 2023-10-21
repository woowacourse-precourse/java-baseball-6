package baseball.game.core;

import baseball.game.service.Answer;
import baseball.game.service.BaseballGame;
import baseball.game.service.dto.Baseball;
import baseball.game.service.dto.BaseballScore;
import baseball.io.input.Input;
import baseball.io.input.validation.InputCommandValidator;
import baseball.io.input.validation.InputValidator;

public class GameLoop {

    private final Input input;
    private final BaseballGame baseballGame;
    private final Answer answer;
    private final GameLifeCycle gameLifeCycle;

    GameLoop(Input input, BaseballGame baseballGame, Answer answer) {
        this.input = input;
        this.baseballGame = baseballGame;
        this.answer = answer;
        this.gameLifeCycle = new GameLifeCycle(GameState.RUNNING);
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameLifeCycle.isRunning()) {
            System.out.print("숫자를 입력해주세요 : ");
            String balls = input.nextLineWithValidation(InputValidator.singleton());
            Baseball myBall = Baseball.of(balls);
            Baseball computerBall = Baseball.of(answer.getAnswer());

            BaseballScore matchResults = baseballGame.match(computerBall, myBall);
            System.out.println(matchResults);
            if (!matchResults.isStrike()) {
                continue;
            }

            GameState promptState = inputWhenStrikes();
            switch (promptState) {
                case FINISH -> gameLifeCycle.finish();
                case RESTART -> answer.regenerateAnswer();
            }
        }
    }

    private GameState inputWhenStrikes() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String select = input.nextLineWithValidation(InputCommandValidator.singleton());

        if (select.equals("1")) {
            return GameState.RESTART;
        }
        return GameState.FINISH;
    }
}
