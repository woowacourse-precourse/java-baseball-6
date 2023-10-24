package baseball;

import baseball.domain.Balls;
import baseball.domain.BallsFactory;
import baseball.domain.Referee;
import baseball.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int next = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (next == 1) {
            Balls computerBalls = BallsFactory.createComputerBalls();
            Referee referee = new Referee();
            while (referee.getStrikeNumber() != 3) {
                List<Integer> ballNumbers = InputView.takeInput();
                Balls playerBalls = BallsFactory.createBalls(ballNumbers);
                referee = computerBalls.play(playerBalls);
                referee.judge();
                next = referee.getNext();
            }
        }
    }
}