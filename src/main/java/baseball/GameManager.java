package baseball;

import java.util.List;
import static baseball.SystemConstant.GAME_DIGIT;
import static baseball.SystemConstant.GAME_EXIT_CODE;

public class GameManager {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BaseballGame baseballGame = new BaseballGame();

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public void playGame() {
        System.out.println(GAME_START_MESSAGE);
        doGameUntilUserQuit();
    }

    private void doGameUntilUserQuit() {
        int control;
        do {
            baseballGame.initComputerNumber();
            doGameLoopUntilGameOver();
            control = inputView.readGameControlInput();
        } while (control != GAME_EXIT_CODE) ;

    }

    private void doGameLoopUntilGameOver() {//true이면, 게임 종료하기 위한 단계로 간다.
        boolean gameLoopOver=false;
        do {
            List<Integer> user = inputView.readGameInput();
            gameLoopOver = playSingleGameRound(user);
        } while (gameLoopOver != true);
    }

    public boolean playSingleGameRound(List<Integer> user){
        Score userScore = baseballGame.computeUserScore(user);
        outputView.printResult(userScore);
        return userScore.getStrike() == GAME_DIGIT;
    }
}
