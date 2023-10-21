package baseball.Config;

import baseball.EndGame.EndProcess;
import baseball.EndGame.EndProcessImpl;
import baseball.Input.InputAnswer;
import baseball.Input.InputAnswerImpl;
import baseball.ProcessGame.BaseBallGame;
import baseball.ProcessGame.BaseBallGameImpl;

public class DiContainer {

    public static InputAnswer getInputAnswer() {
        return InputAnswerImpl.getInstance();
    }

    public static BaseBallGame getBaseBallGame() {
        return BaseBallGameImpl.getInstance();
    }

    public static EndProcess getEndProcess() {
        return EndProcessImpl.getSingleton();
    }

}
