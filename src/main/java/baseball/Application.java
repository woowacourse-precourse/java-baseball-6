package baseball;

import baseball.domain.BallStatus;
import baseball.domain.Balls;
import baseball.domain.BallsFactory;
import baseball.domain.Referee;
import baseball.service.BallGame;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int next = 1;
        while (next == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Balls computerBalls = BallsFactory.createComputerBalls();
            Referee referee = new Referee();
            while (referee.getStrikeNumber() != 3) {
                List<Integer> numbers = InputView.takeInput();
                Balls playerBalls = BallsFactory.createPlayerBalls(numbers);
                List<BallStatus> result = computerBalls.play(playerBalls);
                referee = new Referee();
                referee.classify(result);
                referee.judge();
                next = referee.getNext();
            }
        }
    }
}
