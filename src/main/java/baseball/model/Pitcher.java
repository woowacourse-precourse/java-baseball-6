package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//맞혀야 되는 수를 저장하는 모델
public class Pitcher {
    private List<Integer> pitcherNum;

    public Pitcher() {

    }

    public List<Integer> getPitcherNum() {
        return pitcherNum;
    }

    public void setPitcherNum(List<Integer> pitcherNum) {
        this.pitcherNum = pitcherNum;
    }
}
