package baseball.controller;

import baseball.domain.Pitcher;
import baseball.domain.numberBalls.NumberBalls;
import baseball.domain.Hitter;
import baseball.domain.Result;
import baseball.view.BaseBallView;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BaseBallController {
    private static final BaseBallView baseBallView = BaseBallView.create();
    private Pitcher pitcher;

    private BaseBallController() {
    }

    public static BaseBallController create(Pitcher pitcher) {
        BaseBallController baseBallController = new BaseBallController();
        baseBallController.setPitcher(pitcher);

        return baseBallController;
    }

    private void setPitcher(Pitcher pitcher) {
        this.pitcher = pitcher;
    }

    public void playBall() {
        boolean isContinueBaseBall = Boolean.TRUE;

        while (isContinueBaseBall) {
            isContinueBaseBall = startOneBattle();
        }

        baseBallView.finishView();
    }

    private boolean startOneBattle() {
        Hitter hitter = changeHitter(baseBallView.numbersInputView());
        Result result = pitcher.throwBalls(hitter);

        baseBallView.resultGameView(result.toString());

        return result.isContinue();
    }

    private static Hitter changeHitter(String numberString) {
        return Hitter.create(convertStringToNumbers(numberString));
    }

    private static NumberBalls convertStringToNumbers(String numberString) {
        validateIsInteger(numberString);
        
        return NumberBalls.create(Arrays.stream(numberString.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력가능합니다.");
        }
    }
    

}
