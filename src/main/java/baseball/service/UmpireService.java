package baseball.service;

import baseball.umpire.AllClear;
import baseball.umpire.BaseBallUmpire;

import java.util.List;

public class UmpireService {
    private final BaseBallUmpire baseballUmpire = new BaseBallUmpire();
    private final AllClear allClear = new AllClear();

    public void umpire(String userAnswer, List<String> computer){
        baseballUmpire.umpire(userAnswer,computer);
        baseballUmpire.shouting();
    }

    public boolean isThreeStrike(){
        return baseballUmpire.threeStrikeVAR();
    }

    public boolean isRestart(){
        return allClear.restartOrExit();
    }

}
