package baseball;

import baseball.domain.InputView;
import baseball.domain.Judgement;
import baseball.domain.OutputView;
import baseball.domain.Referee;
import baseball.domain.randomNumberGenerator;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void game() {
        InputView gameSystem = new InputView();
        OutputView output = new OutputView();
        Referee referee = new Referee();

        List<Integer> target = randomNumberGenerator.generateComputer();
        List<Integer> result = Arrays.asList(0,0);

        while (!referee.doesWin(result)) {
            List<Integer> player = gameSystem.readPlayerNumber();
            result = referee.compare(target, player);
            System.out.println(output.gameResult(result));
        }
        output.gameFinished();
    }

    public static void main(String[] args) {
        int newGame = 1;
        while (newGame == 1) {
            try {
                System.out.println("숫자 야구 게임을 시작합니다");
                game();
                newGame = InputView.readNewGame();
            } catch (IllegalArgumentException e) {
                System.out.println("게임 종료");
                newGame = 2;
            }
        }
    }
}
