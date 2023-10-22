package baseball.Controller;

import baseball.domain.RandomNumGenerator;
import baseball.domain.Referee;
import baseball.domain.dto.Score;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.Application.*;

public class GameManager {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public void playGame() {
        System.out.println(GAME_START_MESSAGE);
        doGameUntilUserQuit();
    }

    private void doGameUntilUserQuit() {
        int control;
        do {
            List<Integer> computer = RandomNumGenerator.generateComputerRandomThreeDigitNumber();
            doGameLoopUntilGameOver(computer);
            control = inputView.readGameControlInput();
        } while (control != 2) ;

    }

    private void doGameLoopUntilGameOver(List<Integer> computer) {//true이면, 게임 종료하기 위한 단계로 간다.
        boolean gameLoopOver=false;
        do {
            List<Integer> user = inputView.readGameInput();
            gameLoopOver = playSingleGameRound(user, computer);
        } while (gameLoopOver != true);
    }

    public boolean playSingleGameRound(List<Integer> user,List<Integer> computer){//true이면, 게임 종료하기 위한 단계로 간다.
        Score userScore = Referee.makeScore(user, computer);
        outputView.printResult(userScore);
        return userScore.getStrike() == NUM_DIGITS;
    }
}
