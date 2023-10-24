package baseball.model;

import baseball.view.OutView;

import java.util.List;

public class Game {

    public int setGameResult(List<Integer> userInputNum, List<Integer> computerRandomNum) {
        int ball = 0;
        int strike = 0;
        for(int i = 0; i < userInputNum.size(); i++) {
            if(userInputNum.get(i) == computerRandomNum.get(i)) {
                strike++;
            }else {
                if(computerRandomNum.contains(userInputNum.get(i))) {
                    ball++;
                }
            }
        }
        OutView.gameResult(ball, strike);
        return strike;
    }

    public void end() {
        OutView.end();
    }

    public Boolean checkRestart(String inputRestartNum) {
        return inputRestartNum.equals("1") ? true : false;
    }
}
