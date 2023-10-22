package baseball.controller;

import baseball.model.Hitter;
import baseball.model.Pitcher;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

//게임이 흘러가게 함수 호출을 하는 컨트롤
public class BaseballGame {
    private static final Pitcher pitcher = new Pitcher();
    public static void startGame(){

    }

    public static void pitcherPitch(){
        List<Integer> pitcherNum = new ArrayList<>();
        while (pitcherNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!pitcherNum.contains(randomNumber)) {
                pitcherNum.add(randomNumber);
            }
        }
        pitcher.setPitcherNum(pitcherNum);
    }

    public static List<Integer> hitterSwing(String hitterString) {
        Hitter hitter = new Hitter(hitterString);

        return hitter.getHitterNum();
    }

    
}
