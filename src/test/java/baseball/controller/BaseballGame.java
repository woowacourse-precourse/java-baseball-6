package baseball.controller;

import baseball.model.Hitter;
import baseball.model.Pitcher;
import baseball.model.Referee;
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

    public static String compareNumbers(String hitterString) {
        String result = "";
        List<Integer> pitcherList = pitcher.getPitcherNum();
        List<Integer> hitterList = hitterSwing(hitterString);
        Referee referee = new Referee();

        for(int i = 0; i < 3; i++){
            if(pitcherList.indexOf(hitterList.get(i))==i){
                referee.setStrikes();
            }else if (pitcherList.contains(hitterList.get(i))){
                referee.setBalls();
            }
        }
        if(referee.getStrikes()>0 && referee.getBalls()>0) {
            result = referee.getBalls() + "볼" + " " + referee.getStrikes() + "스트라이크";
        } else if (referee.getStrikes()>0) {
            result = referee.getStrikes() + "스트라이크";
        } else if (referee.getBalls()>0) {
            result = referee.getBalls() + "볼";
        }else {
            result = "낫싱";
        }

        return result;
    }
}
