package baseball.game;

import baseball.context.BaseballContext;

import baseball.context.GameLifeCycle;
import baseball.game.dto.Baseball;
import baseball.game.dto.BaseballScore;
import baseball.io.input.Input;
import baseball.io.input.validation.InputValidator;

public class GameLoop {

    private final Input input;
    private final BaseballContext baseballContext;
    private final BaseballGame baseballGame;
    private final GameLifeCycle gameLifeCycle;

    public GameLoop(Input input, BaseballContext baseballContext, BaseballGame baseballGame) {
        this.input = input;
        this.baseballContext = baseballContext;
        this.baseballGame = baseballGame;
        this.gameLifeCycle = baseballContext.getGameLifeCycle();
    }

    private void promptRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String select = input.nextLine();
        if (select.equals("1")) {
            baseballContext.regenerateAnswer();
            return;
        }
        gameLifeCycle.finish();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameLifeCycle.isRunning()) {
            System.out.print("숫자를 입력해주세요 : ");
            String balls = input.nextLineWithValidation(InputValidator.singleton());
            Baseball computerBall = Baseball.of(baseballContext.getAnswer());
            Baseball myBall = Baseball.of(balls);
            BaseballScore matchResults = baseballGame.match(computerBall, myBall);
            System.out.print(matchResults);

            if (matchResults.isStrike()) {
                promptRestart();
            }
        }
    }
}
