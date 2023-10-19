package baseball.game;

import baseball.context.BaseballContext;

import baseball.game.dto.Baseball;
import baseball.game.dto.BaseballScore;
import baseball.io.input.Input;

public class GameLoop {

    private final Input input;
    private final BaseballContext baseballContext;
    private final BaseballGame baseballGame;

    public GameLoop(Input input, BaseballContext baseballContext, BaseballGame baseballGame) {
        this.input = input;
        this.baseballContext = baseballContext;
        this.baseballGame = baseballGame;
    }

    private void promptRestart() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String select = input.nextLineWithNoEffect();

        if (select.equals("1")) {
            baseballContext.regenerateAnswer();
            return;
        }
        baseballContext.finish();
    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (baseballContext.isRunning()) {
            String balls = input.nextLine();
            BaseballScore matchResults =
                baseballGame.match(Baseball.of(baseballContext.getAnswer()), Baseball.of(balls));
            String transformed = baseballContext.transformer(matchResults);
            System.out.println(transformed);

            if (matchResults.isStrike()) {
                promptRestart();
            }
        }
    }
}
