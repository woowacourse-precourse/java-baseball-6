package baseball;

import baseball.controller.*;

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
