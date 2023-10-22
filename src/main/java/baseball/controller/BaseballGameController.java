package baseball.controller;

import baseball.model.BaseballGameUtils;
import baseball.model.Score;
import baseball.view.BaseballGameView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGameController {

    private BaseballGameView baseballGameView;
    private BaseballGameUtils baseballGameUtils;

    public BaseballGameController() {
        baseballGameView = new BaseballGameView();
        baseballGameUtils = new BaseballGameUtils();
    }

    public boolean startGame() {
        List<Integer> computerNumber = baseballGameUtils.makeComputerNumber();
        List<Integer> userNumber = new ArrayList<>();
        boolean isAnswer = false;

        while (!isAnswer) {

            userNumber = baseballGameView.readUserInputView();
            isVerified(userNumber); // 서로 다른 수인지, 사이즈는 3이 맞는지 확인
            Score result = baseballGameUtils.checkScore(computerNumber, userNumber);
            isAnswer = baseballGameView.showResult(result);
        }

        return baseballGameView.showRestart();
    }

    public void isVerified(List<Integer> userNumber) {
        Set<Integer> userNumberSet = new HashSet<>(userNumber);
        if (userNumberSet.size() != userNumber.size()) {
            throw new IllegalArgumentException("For duplicated numbers");
        }

        if (userNumber.size() != 3) {
            throw new IllegalArgumentException("For incorrect size");
        }

    }


}
