package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.MatchResult;
import baseball.view.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void run() {
        OutputView.printStartGame();
        List<Integer> computerNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        OutputView.printInputNumber();
        List<Integer> numbers = InputView.inputNumber();
        GameResult gameResult = checkResult(numbers, computerNumbers);
        OutputView.printGameResult(gameResult);
    }

    private GameResult checkResult(List<Integer> numbers, List<Integer> computerNumbers) {
         int strike = 0;
         int ball = 0;
        for (int i = 0; i < numbers.size(); i++) {
            Ball player = new Ball(i, numbers.get(i));
            Ball computer = new Ball(i, computerNumbers.get(i));
            MatchResult matchResult = player.match(computer);

            if (matchResult.isStrike()){
                strike++;
            }
            if (matchResult.isBall()) {
                ball++;
            }
        }
        GameResult gameResult = new GameResult(strike, ball);
        return gameResult;
    }

}
