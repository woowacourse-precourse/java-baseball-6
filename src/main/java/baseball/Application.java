package baseball;

import baseball.application.BaseballGame;
import baseball.domain.NumberGenerator;
import baseball.domain.Player;
import baseball.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Player player = new Player(inputView);

        // 1. 게임 시작
        inputView.startGame();

        // 2. 정답 생성
        List<Integer> generatedAnswer = NumberGenerator.generateAnswer();

        // 3. 게임 진행
        while(!player.isGameEnd()) {
            BaseballGame baseballGame = new BaseballGame(generatedAnswer);
            baseballGame.play();
        }
    }
}
