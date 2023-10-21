package baseball.domain;

import static baseball.consts.NumberConst.MAX_STRIKE;

import java.util.List;

public class BaseBallGame {

    private List<Integer> computerList;

    public BaseBallGame() {
        ComputerNum computerNum = new ComputerNum();
        computerList = computerNum.buildComputerNum();
    }

    public GameResult compareNumList(List<Integer> userList) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < computerList.size(); i++) {
            if (computerList.get(i) == userList.get(i)) {
                strike++;
            }
            if (computerList.get(i) != userList.get(i) && computerList.contains(userList.get(i))) {
                ball++;
            }
        }
        return new GameResult(ball, strike);
    }

    public boolean isStrikeMax(int strikeCount) {
        return strikeCount == MAX_STRIKE;
    }

    public void buildNewComputerList() {
        ComputerNum computerNum = new ComputerNum();
        computerList = computerNum.buildComputerNum();
    }
}
