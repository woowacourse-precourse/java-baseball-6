package baseball.umpire;

import java.util.List;

public class UmpireService {
    private final BaseBallUmpire baseballUmpire = new BaseBallUmpire();
    private final AllRightAnswer allRightAnswer = new AllRightAnswer();

    public void umpire(String userAnswer, List<String> computer){
        baseballUmpire.umpire(userAnswer,computer);
        baseballUmpire.shouting();
    }

    public boolean var(){
        return baseballUmpire.threeStrikeVAR();
    }

    public String decision(){
        return allRightAnswer.restartOrExit();
    }

}
