package baseball;

import baseball.controller.GenerateTargetNum;
import baseball.controller.GenerateTargetNumImpl;
import baseball.controller.JudgeCountNum;
import baseball.controller.JudgeCountNumImpl;
import baseball.controller.ValidUserNum;
import baseball.controller.ValidUserNumImpl;
import baseball.view.BaseballGame;
import baseball.view.BaseballGameImpl;

public class AppConfig {

    public GenerateTargetNum generateTargetNum(){
        return new GenerateTargetNumImpl();
    }

    public ValidUserNum validUserNum(){
        return new ValidUserNumImpl();
    }

    public JudgeCountNum judgeCountNum(){
        return new JudgeCountNumImpl();
    }

    public BaseballGame baseballGame(){
        return new BaseballGameImpl(generateTargetNum(),validUserNum(),judgeCountNum());
    }


}
