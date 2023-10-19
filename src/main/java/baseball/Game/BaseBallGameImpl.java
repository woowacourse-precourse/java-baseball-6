package baseball.Game;

import baseball.Input.InputAnswer;
import baseball.Input.InputAnswerImpl;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameImpl implements BaseBallGame {

    private static InputAnswer inputAnswer = new InputAnswerImpl();
    private List<Integer> computerNumber;

    @Override
    public void initGame() {

    }

    @Override
    public void playGame() {
    }

    @Override
    public List<Integer> makeRandomNumber() {
        return null;
    }

    @Override
    public Integer countStrike(List<Integer> answer) {
        return null;
    }

    @Override
    public Integer countBall(List<Integer> answer) {
        return null;
    }

    @Override
    public Boolean isNothing(List<Integer> answer) {
        return null;
    }


    @Override
    public void printResult(Integer strike, Integer ball) {

    }
}
