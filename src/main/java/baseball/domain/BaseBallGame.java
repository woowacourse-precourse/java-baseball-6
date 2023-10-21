package baseball.domain;

import static baseball.consts.NumberConst.MAX_STRIKE;

import java.util.List;

public class BaseBallGame {

    private ComputerNum computerNum = new ComputerNum();
    private List<Integer> computerList;

    public BaseBallGame() {
        buildNewComputerList();
    }

    public GameResult compareNumList(List<Integer> userList) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < computerList.size(); i++) {
            int tempComNum = computerList.get(i);
            int tempUserNum = userList.get(i);
            if (tempComNum == tempUserNum) {
                strike++;
            }
            if (tempComNum != tempUserNum && computerList.contains(tempUserNum)) {
                ball++;
            }
        }
        return new GameResult(ball, strike);
    }

    public boolean isStrikeMax(int strikeCount) {
        return strikeCount == MAX_STRIKE;
    }

    public void buildNewComputerList() {
        computerList = computerNum.buildComputerNum();
    }
}
